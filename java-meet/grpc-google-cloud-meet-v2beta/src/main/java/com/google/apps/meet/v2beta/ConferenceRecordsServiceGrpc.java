/*
 * Copyright 2023 Google LLC
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
package com.google.apps.meet.v2beta;

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
    comments = "Source: google/apps/meet/v2beta/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConferenceRecordsServiceGrpc {

  private ConferenceRecordsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.apps.meet.v2beta.ConferenceRecordsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetConferenceRecordRequest,
          com.google.apps.meet.v2beta.ConferenceRecord>
      getGetConferenceRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConferenceRecord",
      requestType = com.google.apps.meet.v2beta.GetConferenceRecordRequest.class,
      responseType = com.google.apps.meet.v2beta.ConferenceRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetConferenceRecordRequest,
          com.google.apps.meet.v2beta.ConferenceRecord>
      getGetConferenceRecordMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetConferenceRecordRequest,
            com.google.apps.meet.v2beta.ConferenceRecord>
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
                      .<com.google.apps.meet.v2beta.GetConferenceRecordRequest,
                          com.google.apps.meet.v2beta.ConferenceRecord>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetConferenceRecord"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetConferenceRecordRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ConferenceRecord.getDefaultInstance()))
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
          com.google.apps.meet.v2beta.ListConferenceRecordsRequest,
          com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
      getListConferenceRecordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConferenceRecords",
      requestType = com.google.apps.meet.v2beta.ListConferenceRecordsRequest.class,
      responseType = com.google.apps.meet.v2beta.ListConferenceRecordsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListConferenceRecordsRequest,
          com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
      getListConferenceRecordsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListConferenceRecordsRequest,
            com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
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
                      .<com.google.apps.meet.v2beta.ListConferenceRecordsRequest,
                          com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConferenceRecords"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListConferenceRecordsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListConferenceRecordsResponse
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
          com.google.apps.meet.v2beta.GetParticipantRequest,
          com.google.apps.meet.v2beta.Participant>
      getGetParticipantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParticipant",
      requestType = com.google.apps.meet.v2beta.GetParticipantRequest.class,
      responseType = com.google.apps.meet.v2beta.Participant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetParticipantRequest,
          com.google.apps.meet.v2beta.Participant>
      getGetParticipantMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetParticipantRequest,
            com.google.apps.meet.v2beta.Participant>
        getGetParticipantMethod;
    if ((getGetParticipantMethod = ConferenceRecordsServiceGrpc.getGetParticipantMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetParticipantMethod = ConferenceRecordsServiceGrpc.getGetParticipantMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetParticipantMethod =
              getGetParticipantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.GetParticipantRequest,
                          com.google.apps.meet.v2beta.Participant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetParticipant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetParticipantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Participant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("GetParticipant"))
                      .build();
        }
      }
    }
    return getGetParticipantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListParticipantsRequest,
          com.google.apps.meet.v2beta.ListParticipantsResponse>
      getListParticipantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParticipants",
      requestType = com.google.apps.meet.v2beta.ListParticipantsRequest.class,
      responseType = com.google.apps.meet.v2beta.ListParticipantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListParticipantsRequest,
          com.google.apps.meet.v2beta.ListParticipantsResponse>
      getListParticipantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListParticipantsRequest,
            com.google.apps.meet.v2beta.ListParticipantsResponse>
        getListParticipantsMethod;
    if ((getListParticipantsMethod = ConferenceRecordsServiceGrpc.getListParticipantsMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListParticipantsMethod = ConferenceRecordsServiceGrpc.getListParticipantsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListParticipantsMethod =
              getListParticipantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.ListParticipantsRequest,
                          com.google.apps.meet.v2beta.ListParticipantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListParticipants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListParticipantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListParticipantsResponse
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
          com.google.apps.meet.v2beta.GetParticipantSessionRequest,
          com.google.apps.meet.v2beta.ParticipantSession>
      getGetParticipantSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParticipantSession",
      requestType = com.google.apps.meet.v2beta.GetParticipantSessionRequest.class,
      responseType = com.google.apps.meet.v2beta.ParticipantSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetParticipantSessionRequest,
          com.google.apps.meet.v2beta.ParticipantSession>
      getGetParticipantSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetParticipantSessionRequest,
            com.google.apps.meet.v2beta.ParticipantSession>
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
                      .<com.google.apps.meet.v2beta.GetParticipantSessionRequest,
                          com.google.apps.meet.v2beta.ParticipantSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetParticipantSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetParticipantSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ParticipantSession.getDefaultInstance()))
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
          com.google.apps.meet.v2beta.ListParticipantSessionsRequest,
          com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
      getListParticipantSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParticipantSessions",
      requestType = com.google.apps.meet.v2beta.ListParticipantSessionsRequest.class,
      responseType = com.google.apps.meet.v2beta.ListParticipantSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListParticipantSessionsRequest,
          com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
      getListParticipantSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListParticipantSessionsRequest,
            com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
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
                      .<com.google.apps.meet.v2beta.ListParticipantSessionsRequest,
                          com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListParticipantSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListParticipantSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListParticipantSessionsResponse
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
          com.google.apps.meet.v2beta.GetRecordingRequest, com.google.apps.meet.v2beta.Recording>
      getGetRecordingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecording",
      requestType = com.google.apps.meet.v2beta.GetRecordingRequest.class,
      responseType = com.google.apps.meet.v2beta.Recording.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetRecordingRequest, com.google.apps.meet.v2beta.Recording>
      getGetRecordingMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetRecordingRequest, com.google.apps.meet.v2beta.Recording>
        getGetRecordingMethod;
    if ((getGetRecordingMethod = ConferenceRecordsServiceGrpc.getGetRecordingMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetRecordingMethod = ConferenceRecordsServiceGrpc.getGetRecordingMethod) == null) {
          ConferenceRecordsServiceGrpc.getGetRecordingMethod =
              getGetRecordingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.GetRecordingRequest,
                          com.google.apps.meet.v2beta.Recording>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecording"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetRecordingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Recording.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("GetRecording"))
                      .build();
        }
      }
    }
    return getGetRecordingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListRecordingsRequest,
          com.google.apps.meet.v2beta.ListRecordingsResponse>
      getListRecordingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecordings",
      requestType = com.google.apps.meet.v2beta.ListRecordingsRequest.class,
      responseType = com.google.apps.meet.v2beta.ListRecordingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListRecordingsRequest,
          com.google.apps.meet.v2beta.ListRecordingsResponse>
      getListRecordingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListRecordingsRequest,
            com.google.apps.meet.v2beta.ListRecordingsResponse>
        getListRecordingsMethod;
    if ((getListRecordingsMethod = ConferenceRecordsServiceGrpc.getListRecordingsMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListRecordingsMethod = ConferenceRecordsServiceGrpc.getListRecordingsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListRecordingsMethod =
              getListRecordingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.ListRecordingsRequest,
                          com.google.apps.meet.v2beta.ListRecordingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRecordings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListRecordingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListRecordingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("ListRecordings"))
                      .build();
        }
      }
    }
    return getListRecordingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetTranscriptRequest, com.google.apps.meet.v2beta.Transcript>
      getGetTranscriptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTranscript",
      requestType = com.google.apps.meet.v2beta.GetTranscriptRequest.class,
      responseType = com.google.apps.meet.v2beta.Transcript.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetTranscriptRequest, com.google.apps.meet.v2beta.Transcript>
      getGetTranscriptMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetTranscriptRequest,
            com.google.apps.meet.v2beta.Transcript>
        getGetTranscriptMethod;
    if ((getGetTranscriptMethod = ConferenceRecordsServiceGrpc.getGetTranscriptMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetTranscriptMethod = ConferenceRecordsServiceGrpc.getGetTranscriptMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetTranscriptMethod =
              getGetTranscriptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.GetTranscriptRequest,
                          com.google.apps.meet.v2beta.Transcript>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTranscript"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetTranscriptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Transcript.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("GetTranscript"))
                      .build();
        }
      }
    }
    return getGetTranscriptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListTranscriptsRequest,
          com.google.apps.meet.v2beta.ListTranscriptsResponse>
      getListTranscriptsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTranscripts",
      requestType = com.google.apps.meet.v2beta.ListTranscriptsRequest.class,
      responseType = com.google.apps.meet.v2beta.ListTranscriptsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListTranscriptsRequest,
          com.google.apps.meet.v2beta.ListTranscriptsResponse>
      getListTranscriptsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListTranscriptsRequest,
            com.google.apps.meet.v2beta.ListTranscriptsResponse>
        getListTranscriptsMethod;
    if ((getListTranscriptsMethod = ConferenceRecordsServiceGrpc.getListTranscriptsMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListTranscriptsMethod = ConferenceRecordsServiceGrpc.getListTranscriptsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListTranscriptsMethod =
              getListTranscriptsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.ListTranscriptsRequest,
                          com.google.apps.meet.v2beta.ListTranscriptsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTranscripts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListTranscriptsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListTranscriptsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("ListTranscripts"))
                      .build();
        }
      }
    }
    return getListTranscriptsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetTranscriptEntryRequest,
          com.google.apps.meet.v2beta.TranscriptEntry>
      getGetTranscriptEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTranscriptEntry",
      requestType = com.google.apps.meet.v2beta.GetTranscriptEntryRequest.class,
      responseType = com.google.apps.meet.v2beta.TranscriptEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetTranscriptEntryRequest,
          com.google.apps.meet.v2beta.TranscriptEntry>
      getGetTranscriptEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetTranscriptEntryRequest,
            com.google.apps.meet.v2beta.TranscriptEntry>
        getGetTranscriptEntryMethod;
    if ((getGetTranscriptEntryMethod = ConferenceRecordsServiceGrpc.getGetTranscriptEntryMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetTranscriptEntryMethod = ConferenceRecordsServiceGrpc.getGetTranscriptEntryMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetTranscriptEntryMethod =
              getGetTranscriptEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.GetTranscriptEntryRequest,
                          com.google.apps.meet.v2beta.TranscriptEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTranscriptEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetTranscriptEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.TranscriptEntry.getDefaultInstance()))
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
          com.google.apps.meet.v2beta.ListTranscriptEntriesRequest,
          com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
      getListTranscriptEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTranscriptEntries",
      requestType = com.google.apps.meet.v2beta.ListTranscriptEntriesRequest.class,
      responseType = com.google.apps.meet.v2beta.ListTranscriptEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListTranscriptEntriesRequest,
          com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
      getListTranscriptEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListTranscriptEntriesRequest,
            com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
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
                      .<com.google.apps.meet.v2beta.ListTranscriptEntriesRequest,
                          com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTranscriptEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListTranscriptEntriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListTranscriptEntriesResponse
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a conference record by conference ID.
     * </pre>
     */
    default void getConferenceRecord(
        com.google.apps.meet.v2beta.GetConferenceRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ConferenceRecord>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConferenceRecordMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the conference records by start time and in descending order.
     * </pre>
     */
    default void listConferenceRecords(
        com.google.apps.meet.v2beta.ListConferenceRecordsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConferenceRecordsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant by participant ID.
     * </pre>
     */
    default void getParticipant(
        com.google.apps.meet.v2beta.GetParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Participant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParticipantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participants in a conference record, by default ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    default void listParticipants(
        com.google.apps.meet.v2beta.ListParticipantsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListParticipantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParticipantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant session by participant session ID.
     * </pre>
     */
    default void getParticipantSession(
        com.google.apps.meet.v2beta.GetParticipantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ParticipantSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParticipantSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participant sessions of a participant in a conference record, by
     * default ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    default void listParticipantSessions(
        com.google.apps.meet.v2beta.ListParticipantSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParticipantSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a recording by recording ID.
     * </pre>
     */
    default void getRecording(
        com.google.apps.meet.v2beta.GetRecordingRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Recording> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRecordingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the recording resources from the conference record.
     * </pre>
     */
    default void listRecordings(
        com.google.apps.meet.v2beta.ListRecordingsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListRecordingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRecordingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a transcript by transcript ID.
     * </pre>
     */
    default void getTranscript(
        com.google.apps.meet.v2beta.GetTranscriptRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Transcript> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTranscriptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the set of transcripts from the conference record.
     * </pre>
     */
    default void listTranscripts(
        com.google.apps.meet.v2beta.ListTranscriptsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListTranscriptsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTranscriptsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    default void getTranscriptEntry(
        com.google.apps.meet.v2beta.GetTranscriptEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.TranscriptEntry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTranscriptEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    default void listTranscriptEntries(
        com.google.apps.meet.v2beta.ListTranscriptEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a conference record by conference ID.
     * </pre>
     */
    public void getConferenceRecord(
        com.google.apps.meet.v2beta.GetConferenceRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ConferenceRecord>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConferenceRecordMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the conference records by start time and in descending order.
     * </pre>
     */
    public void listConferenceRecords(
        com.google.apps.meet.v2beta.ListConferenceRecordsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant by participant ID.
     * </pre>
     */
    public void getParticipant(
        com.google.apps.meet.v2beta.GetParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Participant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParticipantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participants in a conference record, by default ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    public void listParticipants(
        com.google.apps.meet.v2beta.ListParticipantsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListParticipantsResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant session by participant session ID.
     * </pre>
     */
    public void getParticipantSession(
        com.google.apps.meet.v2beta.GetParticipantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ParticipantSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParticipantSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participant sessions of a participant in a conference record, by
     * default ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    public void listParticipantSessions(
        com.google.apps.meet.v2beta.ListParticipantSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a recording by recording ID.
     * </pre>
     */
    public void getRecording(
        com.google.apps.meet.v2beta.GetRecordingRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Recording> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecordingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the recording resources from the conference record.
     * </pre>
     */
    public void listRecordings(
        com.google.apps.meet.v2beta.ListRecordingsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListRecordingsResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a transcript by transcript ID.
     * </pre>
     */
    public void getTranscript(
        com.google.apps.meet.v2beta.GetTranscriptRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Transcript> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTranscriptMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the set of transcripts from the conference record.
     * </pre>
     */
    public void listTranscripts(
        com.google.apps.meet.v2beta.ListTranscriptsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListTranscriptsResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public void getTranscriptEntry(
        com.google.apps.meet.v2beta.GetTranscriptEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.TranscriptEntry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTranscriptEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public void listTranscriptEntries(
        com.google.apps.meet.v2beta.ListTranscriptEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a conference record by conference ID.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ConferenceRecord getConferenceRecord(
        com.google.apps.meet.v2beta.GetConferenceRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConferenceRecordMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the conference records by start time and in descending order.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListConferenceRecordsResponse listConferenceRecords(
        com.google.apps.meet.v2beta.ListConferenceRecordsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConferenceRecordsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant by participant ID.
     * </pre>
     */
    public com.google.apps.meet.v2beta.Participant getParticipant(
        com.google.apps.meet.v2beta.GetParticipantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParticipantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participants in a conference record, by default ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListParticipantsResponse listParticipants(
        com.google.apps.meet.v2beta.ListParticipantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParticipantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant session by participant session ID.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ParticipantSession getParticipantSession(
        com.google.apps.meet.v2beta.GetParticipantSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParticipantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participant sessions of a participant in a conference record, by
     * default ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListParticipantSessionsResponse listParticipantSessions(
        com.google.apps.meet.v2beta.ListParticipantSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParticipantSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a recording by recording ID.
     * </pre>
     */
    public com.google.apps.meet.v2beta.Recording getRecording(
        com.google.apps.meet.v2beta.GetRecordingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecordingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the recording resources from the conference record.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListRecordingsResponse listRecordings(
        com.google.apps.meet.v2beta.ListRecordingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRecordingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a transcript by transcript ID.
     * </pre>
     */
    public com.google.apps.meet.v2beta.Transcript getTranscript(
        com.google.apps.meet.v2beta.GetTranscriptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTranscriptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the set of transcripts from the conference record.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListTranscriptsResponse listTranscripts(
        com.google.apps.meet.v2beta.ListTranscriptsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTranscriptsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.apps.meet.v2beta.TranscriptEntry getTranscriptEntry(
        com.google.apps.meet.v2beta.GetTranscriptEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTranscriptEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListTranscriptEntriesResponse listTranscriptEntries(
        com.google.apps.meet.v2beta.ListTranscriptEntriesRequest request) {
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
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a conference record by conference ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ConferenceRecord>
        getConferenceRecord(com.google.apps.meet.v2beta.GetConferenceRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConferenceRecordMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the conference records by start time and in descending order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListConferenceRecordsResponse>
        listConferenceRecords(com.google.apps.meet.v2beta.ListConferenceRecordsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConferenceRecordsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant by participant ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.Participant>
        getParticipant(com.google.apps.meet.v2beta.GetParticipantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParticipantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participants in a conference record, by default ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListParticipantsResponse>
        listParticipants(com.google.apps.meet.v2beta.ListParticipantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParticipantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a participant session by participant session ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ParticipantSession>
        getParticipantSession(com.google.apps.meet.v2beta.GetParticipantSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParticipantSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the participant sessions of a participant in a conference record, by
     * default ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListParticipantSessionsResponse>
        listParticipantSessions(
            com.google.apps.meet.v2beta.ListParticipantSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParticipantSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a recording by recording ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2beta.Recording>
        getRecording(com.google.apps.meet.v2beta.GetRecordingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecordingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the recording resources from the conference record.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListRecordingsResponse>
        listRecordings(com.google.apps.meet.v2beta.ListRecordingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRecordingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a transcript by transcript ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.Transcript>
        getTranscript(com.google.apps.meet.v2beta.GetTranscriptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTranscriptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the set of transcripts from the conference record.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListTranscriptsResponse>
        listTranscripts(com.google.apps.meet.v2beta.ListTranscriptsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTranscriptsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.TranscriptEntry>
        getTranscriptEntry(com.google.apps.meet.v2beta.GetTranscriptEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTranscriptEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview).
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>
        listTranscriptEntries(com.google.apps.meet.v2beta.ListTranscriptEntriesRequest request) {
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
              (com.google.apps.meet.v2beta.GetConferenceRecordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ConferenceRecord>)
                  responseObserver);
          break;
        case METHODID_LIST_CONFERENCE_RECORDS:
          serviceImpl.listConferenceRecords(
              (com.google.apps.meet.v2beta.ListConferenceRecordsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.apps.meet.v2beta.ListConferenceRecordsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PARTICIPANT:
          serviceImpl.getParticipant(
              (com.google.apps.meet.v2beta.GetParticipantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Participant>)
                  responseObserver);
          break;
        case METHODID_LIST_PARTICIPANTS:
          serviceImpl.listParticipants(
              (com.google.apps.meet.v2beta.ListParticipantsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListParticipantsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PARTICIPANT_SESSION:
          serviceImpl.getParticipantSession(
              (com.google.apps.meet.v2beta.GetParticipantSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ParticipantSession>)
                  responseObserver);
          break;
        case METHODID_LIST_PARTICIPANT_SESSIONS:
          serviceImpl.listParticipantSessions(
              (com.google.apps.meet.v2beta.ListParticipantSessionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.apps.meet.v2beta.ListParticipantSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RECORDING:
          serviceImpl.getRecording(
              (com.google.apps.meet.v2beta.GetRecordingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Recording>)
                  responseObserver);
          break;
        case METHODID_LIST_RECORDINGS:
          serviceImpl.listRecordings(
              (com.google.apps.meet.v2beta.ListRecordingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListRecordingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSCRIPT:
          serviceImpl.getTranscript(
              (com.google.apps.meet.v2beta.GetTranscriptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Transcript>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSCRIPTS:
          serviceImpl.listTranscripts(
              (com.google.apps.meet.v2beta.ListTranscriptsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListTranscriptsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSCRIPT_ENTRY:
          serviceImpl.getTranscriptEntry(
              (com.google.apps.meet.v2beta.GetTranscriptEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.TranscriptEntry>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSCRIPT_ENTRIES:
          serviceImpl.listTranscriptEntries(
              (com.google.apps.meet.v2beta.ListTranscriptEntriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>)
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
                    com.google.apps.meet.v2beta.GetConferenceRecordRequest,
                    com.google.apps.meet.v2beta.ConferenceRecord>(
                    service, METHODID_GET_CONFERENCE_RECORD)))
        .addMethod(
            getListConferenceRecordsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListConferenceRecordsRequest,
                    com.google.apps.meet.v2beta.ListConferenceRecordsResponse>(
                    service, METHODID_LIST_CONFERENCE_RECORDS)))
        .addMethod(
            getGetParticipantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetParticipantRequest,
                    com.google.apps.meet.v2beta.Participant>(service, METHODID_GET_PARTICIPANT)))
        .addMethod(
            getListParticipantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListParticipantsRequest,
                    com.google.apps.meet.v2beta.ListParticipantsResponse>(
                    service, METHODID_LIST_PARTICIPANTS)))
        .addMethod(
            getGetParticipantSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetParticipantSessionRequest,
                    com.google.apps.meet.v2beta.ParticipantSession>(
                    service, METHODID_GET_PARTICIPANT_SESSION)))
        .addMethod(
            getListParticipantSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListParticipantSessionsRequest,
                    com.google.apps.meet.v2beta.ListParticipantSessionsResponse>(
                    service, METHODID_LIST_PARTICIPANT_SESSIONS)))
        .addMethod(
            getGetRecordingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetRecordingRequest,
                    com.google.apps.meet.v2beta.Recording>(service, METHODID_GET_RECORDING)))
        .addMethod(
            getListRecordingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListRecordingsRequest,
                    com.google.apps.meet.v2beta.ListRecordingsResponse>(
                    service, METHODID_LIST_RECORDINGS)))
        .addMethod(
            getGetTranscriptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetTranscriptRequest,
                    com.google.apps.meet.v2beta.Transcript>(service, METHODID_GET_TRANSCRIPT)))
        .addMethod(
            getListTranscriptsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListTranscriptsRequest,
                    com.google.apps.meet.v2beta.ListTranscriptsResponse>(
                    service, METHODID_LIST_TRANSCRIPTS)))
        .addMethod(
            getGetTranscriptEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetTranscriptEntryRequest,
                    com.google.apps.meet.v2beta.TranscriptEntry>(
                    service, METHODID_GET_TRANSCRIPT_ENTRY)))
        .addMethod(
            getListTranscriptEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListTranscriptEntriesRequest,
                    com.google.apps.meet.v2beta.ListTranscriptEntriesResponse>(
                    service, METHODID_LIST_TRANSCRIPT_ENTRIES)))
        .build();
  }

  private abstract static class ConferenceRecordsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConferenceRecordsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.apps.meet.v2beta.ServiceProto.getDescriptor();
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
