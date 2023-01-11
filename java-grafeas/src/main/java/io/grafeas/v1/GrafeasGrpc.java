/*
 * Copyright 2019 The Grafeas Authors. All rights reserved.
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

package io.grafeas.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * [Grafeas](https://grafeas.io) API.
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
    comments = "Source: grafeas/v1/grafeas.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GrafeasGrpc {

  private GrafeasGrpc() {}

  public static final String SERVICE_NAME = "grafeas.v1.Grafeas";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceRequest,
      io.grafeas.v1.Occurrence> getGetOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOccurrence",
      requestType = io.grafeas.v1.GetOccurrenceRequest.class,
      responseType = io.grafeas.v1.Occurrence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceRequest,
      io.grafeas.v1.Occurrence> getGetOccurrenceMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence> getGetOccurrenceMethod;
    if ((getGetOccurrenceMethod = GrafeasGrpc.getGetOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getGetOccurrenceMethod = GrafeasGrpc.getGetOccurrenceMethod) == null) {
          GrafeasGrpc.getGetOccurrenceMethod = getGetOccurrenceMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.GetOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Occurrence.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("GetOccurrence"))
              .build();
        }
      }
    }
    return getGetOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.ListOccurrencesRequest,
      io.grafeas.v1.ListOccurrencesResponse> getListOccurrencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOccurrences",
      requestType = io.grafeas.v1.ListOccurrencesRequest.class,
      responseType = io.grafeas.v1.ListOccurrencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.ListOccurrencesRequest,
      io.grafeas.v1.ListOccurrencesResponse> getListOccurrencesMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse> getListOccurrencesMethod;
    if ((getListOccurrencesMethod = GrafeasGrpc.getListOccurrencesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getListOccurrencesMethod = GrafeasGrpc.getListOccurrencesMethod) == null) {
          GrafeasGrpc.getListOccurrencesMethod = getListOccurrencesMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.ListOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.ListOccurrencesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("ListOccurrences"))
              .build();
        }
      }
    }
    return getListOccurrencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOccurrence",
      requestType = io.grafeas.v1.DeleteOccurrenceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty> getDeleteOccurrenceMethod;
    if ((getDeleteOccurrenceMethod = GrafeasGrpc.getDeleteOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getDeleteOccurrenceMethod = GrafeasGrpc.getDeleteOccurrenceMethod) == null) {
          GrafeasGrpc.getDeleteOccurrenceMethod = getDeleteOccurrenceMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.DeleteOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("DeleteOccurrence"))
              .build();
        }
      }
    }
    return getDeleteOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.CreateOccurrenceRequest,
      io.grafeas.v1.Occurrence> getCreateOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOccurrence",
      requestType = io.grafeas.v1.CreateOccurrenceRequest.class,
      responseType = io.grafeas.v1.Occurrence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.CreateOccurrenceRequest,
      io.grafeas.v1.Occurrence> getCreateOccurrenceMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence> getCreateOccurrenceMethod;
    if ((getCreateOccurrenceMethod = GrafeasGrpc.getCreateOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getCreateOccurrenceMethod = GrafeasGrpc.getCreateOccurrenceMethod) == null) {
          GrafeasGrpc.getCreateOccurrenceMethod = getCreateOccurrenceMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.CreateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Occurrence.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("CreateOccurrence"))
              .build();
        }
      }
    }
    return getCreateOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.BatchCreateOccurrencesRequest,
      io.grafeas.v1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateOccurrences",
      requestType = io.grafeas.v1.BatchCreateOccurrencesRequest.class,
      responseType = io.grafeas.v1.BatchCreateOccurrencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.BatchCreateOccurrencesRequest,
      io.grafeas.v1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.BatchCreateOccurrencesRequest, io.grafeas.v1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethod;
    if ((getBatchCreateOccurrencesMethod = GrafeasGrpc.getBatchCreateOccurrencesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getBatchCreateOccurrencesMethod = GrafeasGrpc.getBatchCreateOccurrencesMethod) == null) {
          GrafeasGrpc.getBatchCreateOccurrencesMethod = getBatchCreateOccurrencesMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.BatchCreateOccurrencesRequest, io.grafeas.v1.BatchCreateOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.BatchCreateOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.BatchCreateOccurrencesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("BatchCreateOccurrences"))
              .build();
        }
      }
    }
    return getBatchCreateOccurrencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.UpdateOccurrenceRequest,
      io.grafeas.v1.Occurrence> getUpdateOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOccurrence",
      requestType = io.grafeas.v1.UpdateOccurrenceRequest.class,
      responseType = io.grafeas.v1.Occurrence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.UpdateOccurrenceRequest,
      io.grafeas.v1.Occurrence> getUpdateOccurrenceMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence> getUpdateOccurrenceMethod;
    if ((getUpdateOccurrenceMethod = GrafeasGrpc.getUpdateOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getUpdateOccurrenceMethod = GrafeasGrpc.getUpdateOccurrenceMethod) == null) {
          GrafeasGrpc.getUpdateOccurrenceMethod = getUpdateOccurrenceMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.UpdateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Occurrence.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("UpdateOccurrence"))
              .build();
        }
      }
    }
    return getUpdateOccurrenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceNoteRequest,
      io.grafeas.v1.Note> getGetOccurrenceNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOccurrenceNote",
      requestType = io.grafeas.v1.GetOccurrenceNoteRequest.class,
      responseType = io.grafeas.v1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceNoteRequest,
      io.grafeas.v1.Note> getGetOccurrenceNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note> getGetOccurrenceNoteMethod;
    if ((getGetOccurrenceNoteMethod = GrafeasGrpc.getGetOccurrenceNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getGetOccurrenceNoteMethod = GrafeasGrpc.getGetOccurrenceNoteMethod) == null) {
          GrafeasGrpc.getGetOccurrenceNoteMethod = getGetOccurrenceNoteMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOccurrenceNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.GetOccurrenceNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Note.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("GetOccurrenceNote"))
              .build();
        }
      }
    }
    return getGetOccurrenceNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest,
      io.grafeas.v1.Note> getGetNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNote",
      requestType = io.grafeas.v1.GetNoteRequest.class,
      responseType = io.grafeas.v1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest,
      io.grafeas.v1.Note> getGetNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note> getGetNoteMethod;
    if ((getGetNoteMethod = GrafeasGrpc.getGetNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getGetNoteMethod = GrafeasGrpc.getGetNoteMethod) == null) {
          GrafeasGrpc.getGetNoteMethod = getGetNoteMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.GetNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Note.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("GetNote"))
              .build();
        }
      }
    }
    return getGetNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.ListNotesRequest,
      io.grafeas.v1.ListNotesResponse> getListNotesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotes",
      requestType = io.grafeas.v1.ListNotesRequest.class,
      responseType = io.grafeas.v1.ListNotesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.ListNotesRequest,
      io.grafeas.v1.ListNotesResponse> getListNotesMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse> getListNotesMethod;
    if ((getListNotesMethod = GrafeasGrpc.getListNotesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getListNotesMethod = GrafeasGrpc.getListNotesMethod) == null) {
          GrafeasGrpc.getListNotesMethod = getListNotesMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.ListNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.ListNotesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("ListNotes"))
              .build();
        }
      }
    }
    return getListNotesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNote",
      requestType = io.grafeas.v1.DeleteNoteRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty> getDeleteNoteMethod;
    if ((getDeleteNoteMethod = GrafeasGrpc.getDeleteNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getDeleteNoteMethod = GrafeasGrpc.getDeleteNoteMethod) == null) {
          GrafeasGrpc.getDeleteNoteMethod = getDeleteNoteMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.DeleteNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("DeleteNote"))
              .build();
        }
      }
    }
    return getDeleteNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest,
      io.grafeas.v1.Note> getCreateNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNote",
      requestType = io.grafeas.v1.CreateNoteRequest.class,
      responseType = io.grafeas.v1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest,
      io.grafeas.v1.Note> getCreateNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note> getCreateNoteMethod;
    if ((getCreateNoteMethod = GrafeasGrpc.getCreateNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getCreateNoteMethod = GrafeasGrpc.getCreateNoteMethod) == null) {
          GrafeasGrpc.getCreateNoteMethod = getCreateNoteMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.CreateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Note.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("CreateNote"))
              .build();
        }
      }
    }
    return getCreateNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.BatchCreateNotesRequest,
      io.grafeas.v1.BatchCreateNotesResponse> getBatchCreateNotesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateNotes",
      requestType = io.grafeas.v1.BatchCreateNotesRequest.class,
      responseType = io.grafeas.v1.BatchCreateNotesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.BatchCreateNotesRequest,
      io.grafeas.v1.BatchCreateNotesResponse> getBatchCreateNotesMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse> getBatchCreateNotesMethod;
    if ((getBatchCreateNotesMethod = GrafeasGrpc.getBatchCreateNotesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getBatchCreateNotesMethod = GrafeasGrpc.getBatchCreateNotesMethod) == null) {
          GrafeasGrpc.getBatchCreateNotesMethod = getBatchCreateNotesMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateNotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.BatchCreateNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.BatchCreateNotesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("BatchCreateNotes"))
              .build();
        }
      }
    }
    return getBatchCreateNotesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest,
      io.grafeas.v1.Note> getUpdateNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNote",
      requestType = io.grafeas.v1.UpdateNoteRequest.class,
      responseType = io.grafeas.v1.Note.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest,
      io.grafeas.v1.Note> getUpdateNoteMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note> getUpdateNoteMethod;
    if ((getUpdateNoteMethod = GrafeasGrpc.getUpdateNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getUpdateNoteMethod = GrafeasGrpc.getUpdateNoteMethod) == null) {
          GrafeasGrpc.getUpdateNoteMethod = getUpdateNoteMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.UpdateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.Note.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("UpdateNote"))
              .build();
        }
      }
    }
    return getUpdateNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.ListNoteOccurrencesRequest,
      io.grafeas.v1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNoteOccurrences",
      requestType = io.grafeas.v1.ListNoteOccurrencesRequest.class,
      responseType = io.grafeas.v1.ListNoteOccurrencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grafeas.v1.ListNoteOccurrencesRequest,
      io.grafeas.v1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod() {
    io.grpc.MethodDescriptor<io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod;
    if ((getListNoteOccurrencesMethod = GrafeasGrpc.getListNoteOccurrencesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getListNoteOccurrencesMethod = GrafeasGrpc.getListNoteOccurrencesMethod) == null) {
          GrafeasGrpc.getListNoteOccurrencesMethod = getListNoteOccurrencesMethod =
              io.grpc.MethodDescriptor.<io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNoteOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.ListNoteOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1.ListNoteOccurrencesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("ListNoteOccurrences"))
              .build();
        }
      }
    }
    return getListNoteOccurrencesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrafeasStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrafeasStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrafeasStub>() {
        @java.lang.Override
        public GrafeasStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrafeasStub(channel, callOptions);
        }
      };
    return GrafeasStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrafeasBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrafeasBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrafeasBlockingStub>() {
        @java.lang.Override
        public GrafeasBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrafeasBlockingStub(channel, callOptions);
        }
      };
    return GrafeasBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrafeasFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GrafeasFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GrafeasFutureStub>() {
        @java.lang.Override
        public GrafeasFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GrafeasFutureStub(channel, callOptions);
        }
      };
    return GrafeasFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * [Grafeas](https://grafeas.io) API.
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
  public static abstract class GrafeasImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(io.grafeas.v1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOccurrenceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(io.grafeas.v1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListOccurrencesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListOccurrencesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public void deleteOccurrence(io.grafeas.v1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteOccurrenceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(io.grafeas.v1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOccurrenceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(io.grafeas.v1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateOccurrencesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateOccurrencesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(io.grafeas.v1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateOccurrenceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public void getOccurrenceNote(io.grafeas.v1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOccurrenceNoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(io.grafeas.v1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(io.grafeas.v1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNotesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNotesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(io.grafeas.v1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(io.grafeas.v1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(io.grafeas.v1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateNotesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateNotesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(io.grafeas.v1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public void listNoteOccurrences(io.grafeas.v1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNoteOccurrencesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNoteOccurrencesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOccurrenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.GetOccurrenceRequest,
                io.grafeas.v1.Occurrence>(
                  this, METHODID_GET_OCCURRENCE)))
          .addMethod(
            getListOccurrencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.ListOccurrencesRequest,
                io.grafeas.v1.ListOccurrencesResponse>(
                  this, METHODID_LIST_OCCURRENCES)))
          .addMethod(
            getDeleteOccurrenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.DeleteOccurrenceRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_OCCURRENCE)))
          .addMethod(
            getCreateOccurrenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.CreateOccurrenceRequest,
                io.grafeas.v1.Occurrence>(
                  this, METHODID_CREATE_OCCURRENCE)))
          .addMethod(
            getBatchCreateOccurrencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.BatchCreateOccurrencesRequest,
                io.grafeas.v1.BatchCreateOccurrencesResponse>(
                  this, METHODID_BATCH_CREATE_OCCURRENCES)))
          .addMethod(
            getUpdateOccurrenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.UpdateOccurrenceRequest,
                io.grafeas.v1.Occurrence>(
                  this, METHODID_UPDATE_OCCURRENCE)))
          .addMethod(
            getGetOccurrenceNoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.GetOccurrenceNoteRequest,
                io.grafeas.v1.Note>(
                  this, METHODID_GET_OCCURRENCE_NOTE)))
          .addMethod(
            getGetNoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.GetNoteRequest,
                io.grafeas.v1.Note>(
                  this, METHODID_GET_NOTE)))
          .addMethod(
            getListNotesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.ListNotesRequest,
                io.grafeas.v1.ListNotesResponse>(
                  this, METHODID_LIST_NOTES)))
          .addMethod(
            getDeleteNoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.DeleteNoteRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_NOTE)))
          .addMethod(
            getCreateNoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.CreateNoteRequest,
                io.grafeas.v1.Note>(
                  this, METHODID_CREATE_NOTE)))
          .addMethod(
            getBatchCreateNotesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.BatchCreateNotesRequest,
                io.grafeas.v1.BatchCreateNotesResponse>(
                  this, METHODID_BATCH_CREATE_NOTES)))
          .addMethod(
            getUpdateNoteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.UpdateNoteRequest,
                io.grafeas.v1.Note>(
                  this, METHODID_UPDATE_NOTE)))
          .addMethod(
            getListNoteOccurrencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1.ListNoteOccurrencesRequest,
                io.grafeas.v1.ListNoteOccurrencesResponse>(
                  this, METHODID_LIST_NOTE_OCCURRENCES)))
          .build();
    }
  }

  /**
   * <pre>
   * [Grafeas](https://grafeas.io) API.
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
  public static final class GrafeasStub extends io.grpc.stub.AbstractAsyncStub<GrafeasStub> {
    private GrafeasStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(io.grafeas.v1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(io.grafeas.v1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListOccurrencesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOccurrencesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public void deleteOccurrence(io.grafeas.v1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(io.grafeas.v1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(io.grafeas.v1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateOccurrencesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(io.grafeas.v1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public void getOccurrenceNote(io.grafeas.v1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(io.grafeas.v1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(io.grafeas.v1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNotesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(io.grafeas.v1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(io.grafeas.v1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(io.grafeas.v1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateNotesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(io.grafeas.v1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public void listNoteOccurrences(io.grafeas.v1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNoteOccurrencesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * [Grafeas](https://grafeas.io) API.
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
  public static final class GrafeasBlockingStub extends io.grpc.stub.AbstractBlockingStub<GrafeasBlockingStub> {
    private GrafeasBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1.Occurrence getOccurrence(io.grafeas.v1.GetOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public io.grafeas.v1.ListOccurrencesResponse listOccurrences(io.grafeas.v1.ListOccurrencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOccurrencesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteOccurrence(io.grafeas.v1.DeleteOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public io.grafeas.v1.Occurrence createOccurrence(io.grafeas.v1.CreateOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public io.grafeas.v1.BatchCreateOccurrencesResponse batchCreateOccurrences(io.grafeas.v1.BatchCreateOccurrencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateOccurrencesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1.Occurrence updateOccurrence(io.grafeas.v1.UpdateOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOccurrenceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public io.grafeas.v1.Note getOccurrenceNote(io.grafeas.v1.GetOccurrenceNoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOccurrenceNoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public io.grafeas.v1.Note getNote(io.grafeas.v1.GetNoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public io.grafeas.v1.ListNotesResponse listNotes(io.grafeas.v1.ListNotesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNote(io.grafeas.v1.DeleteNoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public io.grafeas.v1.Note createNote(io.grafeas.v1.CreateNoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public io.grafeas.v1.BatchCreateNotesResponse batchCreateNotes(io.grafeas.v1.BatchCreateNotesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateNotesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public io.grafeas.v1.Note updateNote(io.grafeas.v1.UpdateNoteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public io.grafeas.v1.ListNoteOccurrencesResponse listNoteOccurrences(io.grafeas.v1.ListNoteOccurrencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNoteOccurrencesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * [Grafeas](https://grafeas.io) API.
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
  public static final class GrafeasFutureStub extends io.grpc.stub.AbstractFutureStub<GrafeasFutureStub> {
    private GrafeasFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Occurrence> getOccurrence(
        io.grafeas.v1.GetOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.ListOccurrencesResponse> listOccurrences(
        io.grafeas.v1.ListOccurrencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOccurrencesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteOccurrence(
        io.grafeas.v1.DeleteOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Occurrence> createOccurrence(
        io.grafeas.v1.CreateOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.BatchCreateOccurrencesResponse> batchCreateOccurrences(
        io.grafeas.v1.BatchCreateOccurrencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Occurrence> updateOccurrence(
        io.grafeas.v1.UpdateOccurrenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> getOccurrenceNote(
        io.grafeas.v1.GetOccurrenceNoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> getNote(
        io.grafeas.v1.GetNoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.ListNotesResponse> listNotes(
        io.grafeas.v1.ListNotesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNote(
        io.grafeas.v1.DeleteNoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> createNote(
        io.grafeas.v1.CreateNoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.BatchCreateNotesResponse> batchCreateNotes(
        io.grafeas.v1.BatchCreateNotesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> updateNote(
        io.grafeas.v1.UpdateNoteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.ListNoteOccurrencesResponse> listNoteOccurrences(
        io.grafeas.v1.ListNoteOccurrencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethod(), getCallOptions()), request);
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

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrafeasImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrafeasImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_OCCURRENCE:
          serviceImpl.getOccurrence((io.grafeas.v1.GetOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence>) responseObserver);
          break;
        case METHODID_LIST_OCCURRENCES:
          serviceImpl.listOccurrences((io.grafeas.v1.ListOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.ListOccurrencesResponse>) responseObserver);
          break;
        case METHODID_DELETE_OCCURRENCE:
          serviceImpl.deleteOccurrence((io.grafeas.v1.DeleteOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_OCCURRENCE:
          serviceImpl.createOccurrence((io.grafeas.v1.CreateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_OCCURRENCES:
          serviceImpl.batchCreateOccurrences((io.grafeas.v1.BatchCreateOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateOccurrencesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_OCCURRENCE:
          serviceImpl.updateOccurrence((io.grafeas.v1.UpdateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence>) responseObserver);
          break;
        case METHODID_GET_OCCURRENCE_NOTE:
          serviceImpl.getOccurrenceNote((io.grafeas.v1.GetOccurrenceNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_GET_NOTE:
          serviceImpl.getNote((io.grafeas.v1.GetNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTES:
          serviceImpl.listNotes((io.grafeas.v1.ListNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.ListNotesResponse>) responseObserver);
          break;
        case METHODID_DELETE_NOTE:
          serviceImpl.deleteNote((io.grafeas.v1.DeleteNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_NOTE:
          serviceImpl.createNote((io.grafeas.v1.CreateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_NOTES:
          serviceImpl.batchCreateNotes((io.grafeas.v1.BatchCreateNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateNotesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_NOTE:
          serviceImpl.updateNote((io.grafeas.v1.UpdateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTE_OCCURRENCES:
          serviceImpl.listNoteOccurrences((io.grafeas.v1.ListNoteOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.ListNoteOccurrencesResponse>) responseObserver);
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

  private static abstract class GrafeasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrafeasBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grafeas.v1.GrafeasOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Grafeas");
    }
  }

  private static final class GrafeasFileDescriptorSupplier
      extends GrafeasBaseDescriptorSupplier {
    GrafeasFileDescriptorSupplier() {}
  }

  private static final class GrafeasMethodDescriptorSupplier
      extends GrafeasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrafeasMethodDescriptorSupplier(String methodName) {
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
      synchronized (GrafeasGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrafeasFileDescriptorSupplier())
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
              .build();
        }
      }
    }
    return result;
  }
}
