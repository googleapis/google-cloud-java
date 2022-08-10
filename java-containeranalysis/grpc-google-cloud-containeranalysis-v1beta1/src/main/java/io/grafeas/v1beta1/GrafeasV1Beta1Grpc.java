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
package io.grafeas.v1beta1;

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
 * [Grafeas](grafeas.io) API.
 * Retrieves analysis results of Cloud components such as Docker container
 * images.
 * Analysis results are stored as a series of occurrences. An `Occurrence`
 * contains information about a specific analysis instance on a resource. An
 * occurrence refers to a `Note`. A note contains details describing the
 * analysis and is generally stored in a separate project, called a `Provider`.
 * Multiple occurrences can refer to the same note.
 * For example, an SSL vulnerability could affect multiple images. In this case,
 * there would be one note for the vulnerability and an occurrence for each
 * image with the vulnerability referring to that note.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/containeranalysis/v1beta1/grafeas/grafeas.proto")
public final class GrafeasV1Beta1Grpc {

  private GrafeasV1Beta1Grpc() {}

  public static final String SERVICE_NAME = "grafeas.v1beta1.GrafeasV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
      getGetOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOccurrence",
      requestType = io.grafeas.v1beta1.GetOccurrenceRequest.class,
      responseType = io.grafeas.v1beta1.Occurrence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
      getGetOccurrenceMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
        getGetOccurrenceMethod;
    if ((getGetOccurrenceMethod = GrafeasV1Beta1Grpc.getGetOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetOccurrenceMethod = GrafeasV1Beta1Grpc.getGetOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getGetOccurrenceMethod =
              getGetOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.GetOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Occurrence.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("GetOccurrence"))
                      .build();
        }
      }
    }
    return getGetOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.ListOccurrencesRequest, io.grafeas.v1beta1.ListOccurrencesResponse>
      getListOccurrencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOccurrences",
      requestType = io.grafeas.v1beta1.ListOccurrencesRequest.class,
      responseType = io.grafeas.v1beta1.ListOccurrencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.ListOccurrencesRequest, io.grafeas.v1beta1.ListOccurrencesResponse>
      getListOccurrencesMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.ListOccurrencesRequest, io.grafeas.v1beta1.ListOccurrencesResponse>
        getListOccurrencesMethod;
    if ((getListOccurrencesMethod = GrafeasV1Beta1Grpc.getListOccurrencesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getListOccurrencesMethod = GrafeasV1Beta1Grpc.getListOccurrencesMethod) == null) {
          GrafeasV1Beta1Grpc.getListOccurrencesMethod =
              getListOccurrencesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.ListOccurrencesRequest,
                          io.grafeas.v1beta1.ListOccurrencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOccurrences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.ListOccurrencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.ListOccurrencesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("ListOccurrences"))
                      .build();
        }
      }
    }
    return getListOccurrencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
      getDeleteOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOccurrence",
      requestType = io.grafeas.v1beta1.DeleteOccurrenceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
      getDeleteOccurrenceMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
        getDeleteOccurrenceMethod;
    if ((getDeleteOccurrenceMethod = GrafeasV1Beta1Grpc.getDeleteOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getDeleteOccurrenceMethod = GrafeasV1Beta1Grpc.getDeleteOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getDeleteOccurrenceMethod =
              getDeleteOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.DeleteOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("DeleteOccurrence"))
                      .build();
        }
      }
    }
    return getDeleteOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
      getCreateOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOccurrence",
      requestType = io.grafeas.v1beta1.CreateOccurrenceRequest.class,
      responseType = io.grafeas.v1beta1.Occurrence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
      getCreateOccurrenceMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
        getCreateOccurrenceMethod;
    if ((getCreateOccurrenceMethod = GrafeasV1Beta1Grpc.getCreateOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getCreateOccurrenceMethod = GrafeasV1Beta1Grpc.getCreateOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getCreateOccurrenceMethod =
              getCreateOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.CreateOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Occurrence.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("CreateOccurrence"))
                      .build();
        }
      }
    }
    return getCreateOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
          io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
      getBatchCreateOccurrencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateOccurrences",
      requestType = io.grafeas.v1beta1.BatchCreateOccurrencesRequest.class,
      responseType = io.grafeas.v1beta1.BatchCreateOccurrencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
          io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
      getBatchCreateOccurrencesMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
            io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
        getBatchCreateOccurrencesMethod;
    if ((getBatchCreateOccurrencesMethod = GrafeasV1Beta1Grpc.getBatchCreateOccurrencesMethod)
        == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getBatchCreateOccurrencesMethod = GrafeasV1Beta1Grpc.getBatchCreateOccurrencesMethod)
            == null) {
          GrafeasV1Beta1Grpc.getBatchCreateOccurrencesMethod =
              getBatchCreateOccurrencesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
                          io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateOccurrences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.BatchCreateOccurrencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.BatchCreateOccurrencesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("BatchCreateOccurrences"))
                      .build();
        }
      }
    }
    return getBatchCreateOccurrencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
      getUpdateOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOccurrence",
      requestType = io.grafeas.v1beta1.UpdateOccurrenceRequest.class,
      responseType = io.grafeas.v1beta1.Occurrence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
      getUpdateOccurrenceMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
        getUpdateOccurrenceMethod;
    if ((getUpdateOccurrenceMethod = GrafeasV1Beta1Grpc.getUpdateOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getUpdateOccurrenceMethod = GrafeasV1Beta1Grpc.getUpdateOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getUpdateOccurrenceMethod =
              getUpdateOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.UpdateOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Occurrence.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("UpdateOccurrence"))
                      .build();
        }
      }
    }
    return getUpdateOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note>
      getGetOccurrenceNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOccurrenceNote",
      requestType = io.grafeas.v1beta1.GetOccurrenceNoteRequest.class,
      responseType = io.grafeas.v1beta1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note>
      getGetOccurrenceNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note>
        getGetOccurrenceNoteMethod;
    if ((getGetOccurrenceNoteMethod = GrafeasV1Beta1Grpc.getGetOccurrenceNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetOccurrenceNoteMethod = GrafeasV1Beta1Grpc.getGetOccurrenceNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getGetOccurrenceNoteMethod =
              getGetOccurrenceNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOccurrenceNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.GetOccurrenceNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("GetOccurrenceNote"))
                      .build();
        }
      }
    }
    return getGetOccurrenceNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note>
      getGetNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNote",
      requestType = io.grafeas.v1beta1.GetNoteRequest.class,
      responseType = io.grafeas.v1beta1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note>
      getGetNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note>
        getGetNoteMethod;
    if ((getGetNoteMethod = GrafeasV1Beta1Grpc.getGetNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetNoteMethod = GrafeasV1Beta1Grpc.getGetNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getGetNoteMethod =
              getGetNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.GetNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("GetNote"))
                      .build();
        }
      }
    }
    return getGetNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse>
      getListNotesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotes",
      requestType = io.grafeas.v1beta1.ListNotesRequest.class,
      responseType = io.grafeas.v1beta1.ListNotesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse>
      getListNotesMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse>
        getListNotesMethod;
    if ((getListNotesMethod = GrafeasV1Beta1Grpc.getListNotesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getListNotesMethod = GrafeasV1Beta1Grpc.getListNotesMethod) == null) {
          GrafeasV1Beta1Grpc.getListNotesMethod =
              getListNotesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNotes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.ListNotesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.ListNotesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("ListNotes"))
                      .build();
        }
      }
    }
    return getListNotesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty>
      getDeleteNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNote",
      requestType = io.grafeas.v1beta1.DeleteNoteRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty>
      getDeleteNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty>
        getDeleteNoteMethod;
    if ((getDeleteNoteMethod = GrafeasV1Beta1Grpc.getDeleteNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getDeleteNoteMethod = GrafeasV1Beta1Grpc.getDeleteNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getDeleteNoteMethod =
              getDeleteNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.DeleteNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("DeleteNote"))
                      .build();
        }
      }
    }
    return getDeleteNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note>
      getCreateNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNote",
      requestType = io.grafeas.v1beta1.CreateNoteRequest.class,
      responseType = io.grafeas.v1beta1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note>
      getCreateNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note>
        getCreateNoteMethod;
    if ((getCreateNoteMethod = GrafeasV1Beta1Grpc.getCreateNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getCreateNoteMethod = GrafeasV1Beta1Grpc.getCreateNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getCreateNoteMethod =
              getCreateNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.CreateNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("CreateNote"))
                      .build();
        }
      }
    }
    return getCreateNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.BatchCreateNotesRequest, io.grafeas.v1beta1.BatchCreateNotesResponse>
      getBatchCreateNotesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateNotes",
      requestType = io.grafeas.v1beta1.BatchCreateNotesRequest.class,
      responseType = io.grafeas.v1beta1.BatchCreateNotesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.BatchCreateNotesRequest, io.grafeas.v1beta1.BatchCreateNotesResponse>
      getBatchCreateNotesMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.BatchCreateNotesRequest, io.grafeas.v1beta1.BatchCreateNotesResponse>
        getBatchCreateNotesMethod;
    if ((getBatchCreateNotesMethod = GrafeasV1Beta1Grpc.getBatchCreateNotesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getBatchCreateNotesMethod = GrafeasV1Beta1Grpc.getBatchCreateNotesMethod) == null) {
          GrafeasV1Beta1Grpc.getBatchCreateNotesMethod =
              getBatchCreateNotesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.BatchCreateNotesRequest,
                          io.grafeas.v1beta1.BatchCreateNotesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateNotes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.BatchCreateNotesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.BatchCreateNotesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("BatchCreateNotes"))
                      .build();
        }
      }
    }
    return getBatchCreateNotesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note>
      getUpdateNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNote",
      requestType = io.grafeas.v1beta1.UpdateNoteRequest.class,
      responseType = io.grafeas.v1beta1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note>
      getUpdateNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note>
        getUpdateNoteMethod;
    if ((getUpdateNoteMethod = GrafeasV1Beta1Grpc.getUpdateNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getUpdateNoteMethod = GrafeasV1Beta1Grpc.getUpdateNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getUpdateNoteMethod =
              getUpdateNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.UpdateNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("UpdateNote"))
                      .build();
        }
      }
    }
    return getUpdateNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.ListNoteOccurrencesRequest,
          io.grafeas.v1beta1.ListNoteOccurrencesResponse>
      getListNoteOccurrencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNoteOccurrences",
      requestType = io.grafeas.v1beta1.ListNoteOccurrencesRequest.class,
      responseType = io.grafeas.v1beta1.ListNoteOccurrencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.ListNoteOccurrencesRequest,
          io.grafeas.v1beta1.ListNoteOccurrencesResponse>
      getListNoteOccurrencesMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.ListNoteOccurrencesRequest,
            io.grafeas.v1beta1.ListNoteOccurrencesResponse>
        getListNoteOccurrencesMethod;
    if ((getListNoteOccurrencesMethod = GrafeasV1Beta1Grpc.getListNoteOccurrencesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getListNoteOccurrencesMethod = GrafeasV1Beta1Grpc.getListNoteOccurrencesMethod)
            == null) {
          GrafeasV1Beta1Grpc.getListNoteOccurrencesMethod =
              getListNoteOccurrencesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.ListNoteOccurrencesRequest,
                          io.grafeas.v1beta1.ListNoteOccurrencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNoteOccurrences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.ListNoteOccurrencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.ListNoteOccurrencesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier("ListNoteOccurrences"))
                      .build();
        }
      }
    }
    return getListNoteOccurrencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
          io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
      getGetVulnerabilityOccurrencesSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVulnerabilityOccurrencesSummary",
      requestType = io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest.class,
      responseType = io.grafeas.v1beta1.VulnerabilityOccurrencesSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
          io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
      getGetVulnerabilityOccurrencesSummaryMethod() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
            io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
        getGetVulnerabilityOccurrencesSummaryMethod;
    if ((getGetVulnerabilityOccurrencesSummaryMethod =
            GrafeasV1Beta1Grpc.getGetVulnerabilityOccurrencesSummaryMethod)
        == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetVulnerabilityOccurrencesSummaryMethod =
                GrafeasV1Beta1Grpc.getGetVulnerabilityOccurrencesSummaryMethod)
            == null) {
          GrafeasV1Beta1Grpc.getGetVulnerabilityOccurrencesSummaryMethod =
              getGetVulnerabilityOccurrencesSummaryMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
                          io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetVulnerabilityOccurrencesSummary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1beta1.VulnerabilityOccurrencesSummary
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasV1Beta1MethodDescriptorSupplier(
                              "GetVulnerabilityOccurrencesSummary"))
                      .build();
        }
      }
    }
    return getGetVulnerabilityOccurrencesSummaryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GrafeasV1Beta1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrafeasV1Beta1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GrafeasV1Beta1Stub>() {
          @java.lang.Override
          public GrafeasV1Beta1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GrafeasV1Beta1Stub(channel, callOptions);
          }
        };
    return GrafeasV1Beta1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrafeasV1Beta1BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrafeasV1Beta1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GrafeasV1Beta1BlockingStub>() {
          @java.lang.Override
          public GrafeasV1Beta1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GrafeasV1Beta1BlockingStub(channel, callOptions);
          }
        };
    return GrafeasV1Beta1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GrafeasV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrafeasV1Beta1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GrafeasV1Beta1FutureStub>() {
          @java.lang.Override
          public GrafeasV1Beta1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GrafeasV1Beta1FutureStub(channel, callOptions);
          }
        };
    return GrafeasV1Beta1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * [Grafeas](grafeas.io) API.
   * Retrieves analysis results of Cloud components such as Docker container
   * images.
   * Analysis results are stored as a series of occurrences. An `Occurrence`
   * contains information about a specific analysis instance on a resource. An
   * occurrence refers to a `Note`. A note contains details describing the
   * analysis and is generally stored in a separate project, called a `Provider`.
   * Multiple occurrences can refer to the same note.
   * For example, an SSL vulnerability could affect multiple images. In this case,
   * there would be one note for the vulnerability and an occurrence for each
   * image with the vulnerability referring to that note.
   * </pre>
   */
  public abstract static class GrafeasV1Beta1ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(
        io.grafeas.v1beta1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(
        io.grafeas.v1beta1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListOccurrencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public void deleteOccurrence(
        io.grafeas.v1beta1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteOccurrenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(
        io.grafeas.v1beta1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateOccurrenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(
        io.grafeas.v1beta1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateOccurrencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(
        io.grafeas.v1beta1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOccurrenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public void getOccurrenceNote(
        io.grafeas.v1beta1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceNoteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(
        io.grafeas.v1beta1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNoteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(
        io.grafeas.v1beta1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNotesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(
        io.grafeas.v1beta1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteNoteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(
        io.grafeas.v1beta1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNoteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(
        io.grafeas.v1beta1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateNotesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(
        io.grafeas.v1beta1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateNoteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public void listNoteOccurrences(
        io.grafeas.v1beta1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNoteOccurrencesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListNoteOccurrencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public void getVulnerabilityOccurrencesSummary(
        io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetVulnerabilityOccurrencesSummaryMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetOccurrenceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence>(
                      this, METHODID_GET_OCCURRENCE)))
          .addMethod(
              getListOccurrencesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.ListOccurrencesRequest,
                      io.grafeas.v1beta1.ListOccurrencesResponse>(this, METHODID_LIST_OCCURRENCES)))
          .addMethod(
              getDeleteOccurrenceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_OCCURRENCE)))
          .addMethod(
              getCreateOccurrenceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>(
                      this, METHODID_CREATE_OCCURRENCE)))
          .addMethod(
              getBatchCreateOccurrencesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
                      io.grafeas.v1beta1.BatchCreateOccurrencesResponse>(
                      this, METHODID_BATCH_CREATE_OCCURRENCES)))
          .addMethod(
              getUpdateOccurrenceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>(
                      this, METHODID_UPDATE_OCCURRENCE)))
          .addMethod(
              getGetOccurrenceNoteMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note>(
                      this, METHODID_GET_OCCURRENCE_NOTE)))
          .addMethod(
              getGetNoteMethod(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note>(
                      this, METHODID_GET_NOTE)))
          .addMethod(
              getListNotesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse>(
                      this, METHODID_LIST_NOTES)))
          .addMethod(
              getDeleteNoteMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_NOTE)))
          .addMethod(
              getCreateNoteMethod(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note>(
                      this, METHODID_CREATE_NOTE)))
          .addMethod(
              getBatchCreateNotesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.BatchCreateNotesRequest,
                      io.grafeas.v1beta1.BatchCreateNotesResponse>(
                      this, METHODID_BATCH_CREATE_NOTES)))
          .addMethod(
              getUpdateNoteMethod(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note>(
                      this, METHODID_UPDATE_NOTE)))
          .addMethod(
              getListNoteOccurrencesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.ListNoteOccurrencesRequest,
                      io.grafeas.v1beta1.ListNoteOccurrencesResponse>(
                      this, METHODID_LIST_NOTE_OCCURRENCES)))
          .addMethod(
              getGetVulnerabilityOccurrencesSummaryMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
                      io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>(
                      this, METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * [Grafeas](grafeas.io) API.
   * Retrieves analysis results of Cloud components such as Docker container
   * images.
   * Analysis results are stored as a series of occurrences. An `Occurrence`
   * contains information about a specific analysis instance on a resource. An
   * occurrence refers to a `Note`. A note contains details describing the
   * analysis and is generally stored in a separate project, called a `Provider`.
   * Multiple occurrences can refer to the same note.
   * For example, an SSL vulnerability could affect multiple images. In this case,
   * there would be one note for the vulnerability and an occurrence for each
   * image with the vulnerability referring to that note.
   * </pre>
   */
  public static final class GrafeasV1Beta1Stub
      extends io.grpc.stub.AbstractAsyncStub<GrafeasV1Beta1Stub> {
    private GrafeasV1Beta1Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasV1Beta1Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(
        io.grafeas.v1beta1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(
        io.grafeas.v1beta1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOccurrencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public void deleteOccurrence(
        io.grafeas.v1beta1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(
        io.grafeas.v1beta1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(
        io.grafeas.v1beta1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(
        io.grafeas.v1beta1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public void getOccurrenceNote(
        io.grafeas.v1beta1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(
        io.grafeas.v1beta1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(
        io.grafeas.v1beta1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNotesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(
        io.grafeas.v1beta1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(
        io.grafeas.v1beta1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(
        io.grafeas.v1beta1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(
        io.grafeas.v1beta1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public void listNoteOccurrences(
        io.grafeas.v1beta1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNoteOccurrencesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public void getVulnerabilityOccurrencesSummary(
        io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVulnerabilityOccurrencesSummaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * [Grafeas](grafeas.io) API.
   * Retrieves analysis results of Cloud components such as Docker container
   * images.
   * Analysis results are stored as a series of occurrences. An `Occurrence`
   * contains information about a specific analysis instance on a resource. An
   * occurrence refers to a `Note`. A note contains details describing the
   * analysis and is generally stored in a separate project, called a `Provider`.
   * Multiple occurrences can refer to the same note.
   * For example, an SSL vulnerability could affect multiple images. In this case,
   * there would be one note for the vulnerability and an occurrence for each
   * image with the vulnerability referring to that note.
   * </pre>
   */
  public static final class GrafeasV1Beta1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GrafeasV1Beta1BlockingStub> {
    private GrafeasV1Beta1BlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1beta1.Occurrence getOccurrence(
        io.grafeas.v1beta1.GetOccurrenceRequest request) {
      return blockingUnaryCall(getChannel(), getGetOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public io.grafeas.v1beta1.ListOccurrencesResponse listOccurrences(
        io.grafeas.v1beta1.ListOccurrencesRequest request) {
      return blockingUnaryCall(getChannel(), getListOccurrencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteOccurrence(
        io.grafeas.v1beta1.DeleteOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public io.grafeas.v1beta1.Occurrence createOccurrence(
        io.grafeas.v1beta1.CreateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public io.grafeas.v1beta1.BatchCreateOccurrencesResponse batchCreateOccurrences(
        io.grafeas.v1beta1.BatchCreateOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateOccurrencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1beta1.Occurrence updateOccurrence(
        io.grafeas.v1beta1.UpdateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public io.grafeas.v1beta1.Note getOccurrenceNote(
        io.grafeas.v1beta1.GetOccurrenceNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceNoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public io.grafeas.v1beta1.Note getNote(io.grafeas.v1beta1.GetNoteRequest request) {
      return blockingUnaryCall(getChannel(), getGetNoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public io.grafeas.v1beta1.ListNotesResponse listNotes(
        io.grafeas.v1beta1.ListNotesRequest request) {
      return blockingUnaryCall(getChannel(), getListNotesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNote(io.grafeas.v1beta1.DeleteNoteRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteNoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public io.grafeas.v1beta1.Note createNote(io.grafeas.v1beta1.CreateNoteRequest request) {
      return blockingUnaryCall(getChannel(), getCreateNoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public io.grafeas.v1beta1.BatchCreateNotesResponse batchCreateNotes(
        io.grafeas.v1beta1.BatchCreateNotesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateNotesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public io.grafeas.v1beta1.Note updateNote(io.grafeas.v1beta1.UpdateNoteRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateNoteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public io.grafeas.v1beta1.ListNoteOccurrencesResponse listNoteOccurrences(
        io.grafeas.v1beta1.ListNoteOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNoteOccurrencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public io.grafeas.v1beta1.VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(
        io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetVulnerabilityOccurrencesSummaryMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * [Grafeas](grafeas.io) API.
   * Retrieves analysis results of Cloud components such as Docker container
   * images.
   * Analysis results are stored as a series of occurrences. An `Occurrence`
   * contains information about a specific analysis instance on a resource. An
   * occurrence refers to a `Note`. A note contains details describing the
   * analysis and is generally stored in a separate project, called a `Provider`.
   * Multiple occurrences can refer to the same note.
   * For example, an SSL vulnerability could affect multiple images. In this case,
   * there would be one note for the vulnerability and an occurrence for each
   * image with the vulnerability referring to that note.
   * </pre>
   */
  public static final class GrafeasV1Beta1FutureStub
      extends io.grpc.stub.AbstractFutureStub<GrafeasV1Beta1FutureStub> {
    private GrafeasV1Beta1FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Occurrence>
        getOccurrence(io.grafeas.v1beta1.GetOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1beta1.ListOccurrencesResponse>
        listOccurrences(io.grafeas.v1beta1.ListOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOccurrencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteOccurrence(io.grafeas.v1beta1.DeleteOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Occurrence>
        createOccurrence(io.grafeas.v1beta1.CreateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1beta1.BatchCreateOccurrencesResponse>
        batchCreateOccurrences(io.grafeas.v1beta1.BatchCreateOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Occurrence>
        updateOccurrence(io.grafeas.v1beta1.UpdateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note>
        getOccurrenceNote(io.grafeas.v1beta1.GetOccurrenceNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> getNote(
        io.grafeas.v1beta1.GetNoteRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetNoteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.ListNotesResponse>
        listNotes(io.grafeas.v1beta1.ListNotesRequest request) {
      return futureUnaryCall(getChannel().newCall(getListNotesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNote(
        io.grafeas.v1beta1.DeleteNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteNoteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> createNote(
        io.grafeas.v1beta1.CreateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNoteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1beta1.BatchCreateNotesResponse>
        batchCreateNotes(io.grafeas.v1beta1.BatchCreateNotesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> updateNote(
        io.grafeas.v1beta1.UpdateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateNoteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1beta1.ListNoteOccurrencesResponse>
        listNoteOccurrences(io.grafeas.v1beta1.ListNoteOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>
        getVulnerabilityOccurrencesSummary(
            io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVulnerabilityOccurrencesSummaryMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_OCCURRENCE = 0;
  private static final int METHODID_LIST_OCCURRENCES = 1;
  private static final int METHODID_DELETE_OCCURRENCE = 2;
  private static final int METHODID_CREATE_OCCURRENCE = 3;
  private static final int METHODID_BATCH_CREATE_OCCURRENCES = 4;
  private static final int METHODID_UPDATE_OCCURRENCE = 5;
  private static final int METHODID_GET_OCCURRENCE_NOTE = 6;
  private static final int METHODID_GET_NOTE = 7;
  private static final int METHODID_LIST_NOTES = 8;
  private static final int METHODID_DELETE_NOTE = 9;
  private static final int METHODID_CREATE_NOTE = 10;
  private static final int METHODID_BATCH_CREATE_NOTES = 11;
  private static final int METHODID_UPDATE_NOTE = 12;
  private static final int METHODID_LIST_NOTE_OCCURRENCES = 13;
  private static final int METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY = 14;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrafeasV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrafeasV1Beta1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_OCCURRENCE:
          serviceImpl.getOccurrence(
              (io.grafeas.v1beta1.GetOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence>) responseObserver);
          break;
        case METHODID_LIST_OCCURRENCES:
          serviceImpl.listOccurrences(
              (io.grafeas.v1beta1.ListOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListOccurrencesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_OCCURRENCE:
          serviceImpl.deleteOccurrence(
              (io.grafeas.v1beta1.DeleteOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_OCCURRENCE:
          serviceImpl.createOccurrence(
              (io.grafeas.v1beta1.CreateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_OCCURRENCES:
          serviceImpl.batchCreateOccurrences(
              (io.grafeas.v1beta1.BatchCreateOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateOccurrencesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_OCCURRENCE:
          serviceImpl.updateOccurrence(
              (io.grafeas.v1beta1.UpdateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence>) responseObserver);
          break;
        case METHODID_GET_OCCURRENCE_NOTE:
          serviceImpl.getOccurrenceNote(
              (io.grafeas.v1beta1.GetOccurrenceNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_GET_NOTE:
          serviceImpl.getNote(
              (io.grafeas.v1beta1.GetNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTES:
          serviceImpl.listNotes(
              (io.grafeas.v1beta1.ListNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNotesResponse>) responseObserver);
          break;
        case METHODID_DELETE_NOTE:
          serviceImpl.deleteNote(
              (io.grafeas.v1beta1.DeleteNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_NOTE:
          serviceImpl.createNote(
              (io.grafeas.v1beta1.CreateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_NOTES:
          serviceImpl.batchCreateNotes(
              (io.grafeas.v1beta1.BatchCreateNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateNotesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NOTE:
          serviceImpl.updateNote(
              (io.grafeas.v1beta1.UpdateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTE_OCCURRENCES:
          serviceImpl.listNoteOccurrences(
              (io.grafeas.v1beta1.ListNoteOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNoteOccurrencesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY:
          serviceImpl.getVulnerabilityOccurrencesSummary(
              (io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>)
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

  private abstract static class GrafeasV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrafeasV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grafeas.v1beta1.Grafeas.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrafeasV1Beta1");
    }
  }

  private static final class GrafeasV1Beta1FileDescriptorSupplier
      extends GrafeasV1Beta1BaseDescriptorSupplier {
    GrafeasV1Beta1FileDescriptorSupplier() {}
  }

  private static final class GrafeasV1Beta1MethodDescriptorSupplier
      extends GrafeasV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrafeasV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (GrafeasV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GrafeasV1Beta1FileDescriptorSupplier())
                      .addMethod(getGetOccurrenceMethod())
                      .addMethod(getListOccurrencesMethod())
                      .addMethod(getDeleteOccurrenceMethod())
                      .addMethod(getCreateOccurrenceMethod())
                      .addMethod(getBatchCreateOccurrencesMethod())
                      .addMethod(getUpdateOccurrenceMethod())
                      .addMethod(getGetOccurrenceNoteMethod())
                      .addMethod(getGetNoteMethod())
                      .addMethod(getListNotesMethod())
                      .addMethod(getDeleteNoteMethod())
                      .addMethod(getCreateNoteMethod())
                      .addMethod(getBatchCreateNotesMethod())
                      .addMethod(getUpdateNoteMethod())
                      .addMethod(getListNoteOccurrencesMethod())
                      .addMethod(getGetVulnerabilityOccurrencesSummaryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
