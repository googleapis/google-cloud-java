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
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: grafeas/v1/grafeas.proto")
public final class GrafeasGrpc {

  private GrafeasGrpc() {}

  public static final String SERVICE_NAME = "grafeas.v1.Grafeas";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOccurrenceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>
      METHOD_GET_OCCURRENCE = getGetOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>
      getGetOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>
      getGetOccurrenceMethod() {
    return getGetOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>
      getGetOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>
        getGetOccurrenceMethod;
    if ((getGetOccurrenceMethod = GrafeasGrpc.getGetOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getGetOccurrenceMethod = GrafeasGrpc.getGetOccurrenceMethod) == null) {
          GrafeasGrpc.getGetOccurrenceMethod =
              getGetOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "GetOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.GetOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Occurrence.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("GetOccurrence"))
                      .build();
        }
      }
    }
    return getGetOccurrenceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListOccurrencesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>
      METHOD_LIST_OCCURRENCES = getListOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>
      getListOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>
      getListOccurrencesMethod() {
    return getListOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>
      getListOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>
        getListOccurrencesMethod;
    if ((getListOccurrencesMethod = GrafeasGrpc.getListOccurrencesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getListOccurrencesMethod = GrafeasGrpc.getListOccurrencesMethod) == null) {
          GrafeasGrpc.getListOccurrencesMethod =
              getListOccurrencesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "ListOccurrences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.ListOccurrencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.ListOccurrencesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("ListOccurrences"))
                      .build();
        }
      }
    }
    return getListOccurrencesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteOccurrenceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
      METHOD_DELETE_OCCURRENCE = getDeleteOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
      getDeleteOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
      getDeleteOccurrenceMethod() {
    return getDeleteOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
      getDeleteOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
        getDeleteOccurrenceMethod;
    if ((getDeleteOccurrenceMethod = GrafeasGrpc.getDeleteOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getDeleteOccurrenceMethod = GrafeasGrpc.getDeleteOccurrenceMethod) == null) {
          GrafeasGrpc.getDeleteOccurrenceMethod =
              getDeleteOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "DeleteOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.DeleteOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("DeleteOccurrence"))
                      .build();
        }
      }
    }
    return getDeleteOccurrenceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateOccurrenceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>
      METHOD_CREATE_OCCURRENCE = getCreateOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>
      getCreateOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>
      getCreateOccurrenceMethod() {
    return getCreateOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>
      getCreateOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>
        getCreateOccurrenceMethod;
    if ((getCreateOccurrenceMethod = GrafeasGrpc.getCreateOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getCreateOccurrenceMethod = GrafeasGrpc.getCreateOccurrenceMethod) == null) {
          GrafeasGrpc.getCreateOccurrenceMethod =
              getCreateOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "CreateOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.CreateOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Occurrence.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("CreateOccurrence"))
                      .build();
        }
      }
    }
    return getCreateOccurrenceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateOccurrencesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateOccurrencesRequest, io.grafeas.v1.BatchCreateOccurrencesResponse>
      METHOD_BATCH_CREATE_OCCURRENCES = getBatchCreateOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateOccurrencesRequest, io.grafeas.v1.BatchCreateOccurrencesResponse>
      getBatchCreateOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateOccurrencesRequest, io.grafeas.v1.BatchCreateOccurrencesResponse>
      getBatchCreateOccurrencesMethod() {
    return getBatchCreateOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateOccurrencesRequest, io.grafeas.v1.BatchCreateOccurrencesResponse>
      getBatchCreateOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1.BatchCreateOccurrencesRequest,
            io.grafeas.v1.BatchCreateOccurrencesResponse>
        getBatchCreateOccurrencesMethod;
    if ((getBatchCreateOccurrencesMethod = GrafeasGrpc.getBatchCreateOccurrencesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getBatchCreateOccurrencesMethod = GrafeasGrpc.getBatchCreateOccurrencesMethod)
            == null) {
          GrafeasGrpc.getBatchCreateOccurrencesMethod =
              getBatchCreateOccurrencesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.BatchCreateOccurrencesRequest,
                          io.grafeas.v1.BatchCreateOccurrencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "BatchCreateOccurrences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.BatchCreateOccurrencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.BatchCreateOccurrencesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasMethodDescriptorSupplier("BatchCreateOccurrences"))
                      .build();
        }
      }
    }
    return getBatchCreateOccurrencesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateOccurrenceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>
      METHOD_UPDATE_OCCURRENCE = getUpdateOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>
      getUpdateOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>
      getUpdateOccurrenceMethod() {
    return getUpdateOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>
      getUpdateOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>
        getUpdateOccurrenceMethod;
    if ((getUpdateOccurrenceMethod = GrafeasGrpc.getUpdateOccurrenceMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getUpdateOccurrenceMethod = GrafeasGrpc.getUpdateOccurrenceMethod) == null) {
          GrafeasGrpc.getUpdateOccurrenceMethod =
              getUpdateOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "UpdateOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.UpdateOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Occurrence.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("UpdateOccurrence"))
                      .build();
        }
      }
    }
    return getUpdateOccurrenceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOccurrenceNoteMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>
      METHOD_GET_OCCURRENCE_NOTE = getGetOccurrenceNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>
      getGetOccurrenceNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>
      getGetOccurrenceNoteMethod() {
    return getGetOccurrenceNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>
      getGetOccurrenceNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>
        getGetOccurrenceNoteMethod;
    if ((getGetOccurrenceNoteMethod = GrafeasGrpc.getGetOccurrenceNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getGetOccurrenceNoteMethod = GrafeasGrpc.getGetOccurrenceNoteMethod) == null) {
          GrafeasGrpc.getGetOccurrenceNoteMethod =
              getGetOccurrenceNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "GetOccurrenceNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.GetOccurrenceNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("GetOccurrenceNote"))
                      .build();
        }
      }
    }
    return getGetOccurrenceNoteMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNoteMethod()} instead.
  public static final io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>
      METHOD_GET_NOTE = getGetNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>
      getGetNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>
      getGetNoteMethod() {
    return getGetNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>
      getGetNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note> getGetNoteMethod;
    if ((getGetNoteMethod = GrafeasGrpc.getGetNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getGetNoteMethod = GrafeasGrpc.getGetNoteMethod) == null) {
          GrafeasGrpc.getGetNoteMethod =
              getGetNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName("grafeas.v1.Grafeas", "GetNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.GetNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("GetNote"))
                      .build();
        }
      }
    }
    return getGetNoteMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNotesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>
      METHOD_LIST_NOTES = getListNotesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>
      getListNotesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>
      getListNotesMethod() {
    return getListNotesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>
      getListNotesMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>
        getListNotesMethod;
    if ((getListNotesMethod = GrafeasGrpc.getListNotesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getListNotesMethod = GrafeasGrpc.getListNotesMethod) == null) {
          GrafeasGrpc.getListNotesMethod =
              getListNotesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName("grafeas.v1.Grafeas", "ListNotes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.ListNotesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.ListNotesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("ListNotes"))
                      .build();
        }
      }
    }
    return getListNotesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteNoteMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>
      METHOD_DELETE_NOTE = getDeleteNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>
      getDeleteNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>
      getDeleteNoteMethod() {
    return getDeleteNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>
      getDeleteNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>
        getDeleteNoteMethod;
    if ((getDeleteNoteMethod = GrafeasGrpc.getDeleteNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getDeleteNoteMethod = GrafeasGrpc.getDeleteNoteMethod) == null) {
          GrafeasGrpc.getDeleteNoteMethod =
              getDeleteNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName("grafeas.v1.Grafeas", "DeleteNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.DeleteNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("DeleteNote"))
                      .build();
        }
      }
    }
    return getDeleteNoteMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateNoteMethod()} instead.
  public static final io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>
      METHOD_CREATE_NOTE = getCreateNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>
      getCreateNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>
      getCreateNoteMethod() {
    return getCreateNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>
      getCreateNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>
        getCreateNoteMethod;
    if ((getCreateNoteMethod = GrafeasGrpc.getCreateNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getCreateNoteMethod = GrafeasGrpc.getCreateNoteMethod) == null) {
          GrafeasGrpc.getCreateNoteMethod =
              getCreateNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName("grafeas.v1.Grafeas", "CreateNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.CreateNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("CreateNote"))
                      .build();
        }
      }
    }
    return getCreateNoteMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateNotesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse>
      METHOD_BATCH_CREATE_NOTES = getBatchCreateNotesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse>
      getBatchCreateNotesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse>
      getBatchCreateNotesMethod() {
    return getBatchCreateNotesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse>
      getBatchCreateNotesMethodHelper() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1.BatchCreateNotesRequest, io.grafeas.v1.BatchCreateNotesResponse>
        getBatchCreateNotesMethod;
    if ((getBatchCreateNotesMethod = GrafeasGrpc.getBatchCreateNotesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getBatchCreateNotesMethod = GrafeasGrpc.getBatchCreateNotesMethod) == null) {
          GrafeasGrpc.getBatchCreateNotesMethod =
              getBatchCreateNotesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.BatchCreateNotesRequest,
                          io.grafeas.v1.BatchCreateNotesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "BatchCreateNotes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.BatchCreateNotesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.BatchCreateNotesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("BatchCreateNotes"))
                      .build();
        }
      }
    }
    return getBatchCreateNotesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateNoteMethod()} instead.
  public static final io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>
      METHOD_UPDATE_NOTE = getUpdateNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>
      getUpdateNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>
      getUpdateNoteMethod() {
    return getUpdateNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>
      getUpdateNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>
        getUpdateNoteMethod;
    if ((getUpdateNoteMethod = GrafeasGrpc.getUpdateNoteMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getUpdateNoteMethod = GrafeasGrpc.getUpdateNoteMethod) == null) {
          GrafeasGrpc.getUpdateNoteMethod =
              getUpdateNoteMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName("grafeas.v1.Grafeas", "UpdateNote"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.UpdateNoteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.Note.getDefaultInstance()))
                      .setSchemaDescriptor(new GrafeasMethodDescriptorSupplier("UpdateNote"))
                      .build();
        }
      }
    }
    return getUpdateNoteMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNoteOccurrencesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse>
      METHOD_LIST_NOTE_OCCURRENCES = getListNoteOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse>
      getListNoteOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse>
      getListNoteOccurrencesMethod() {
    return getListNoteOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse>
      getListNoteOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<
            io.grafeas.v1.ListNoteOccurrencesRequest, io.grafeas.v1.ListNoteOccurrencesResponse>
        getListNoteOccurrencesMethod;
    if ((getListNoteOccurrencesMethod = GrafeasGrpc.getListNoteOccurrencesMethod) == null) {
      synchronized (GrafeasGrpc.class) {
        if ((getListNoteOccurrencesMethod = GrafeasGrpc.getListNoteOccurrencesMethod) == null) {
          GrafeasGrpc.getListNoteOccurrencesMethod =
              getListNoteOccurrencesMethod =
                  io.grpc.MethodDescriptor
                      .<io.grafeas.v1.ListNoteOccurrencesRequest,
                          io.grafeas.v1.ListNoteOccurrencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName("grafeas.v1.Grafeas", "ListNoteOccurrences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.ListNoteOccurrencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              io.grafeas.v1.ListNoteOccurrencesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GrafeasMethodDescriptorSupplier("ListNoteOccurrences"))
                      .build();
        }
      }
    }
    return getListNoteOccurrencesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GrafeasStub newStub(io.grpc.Channel channel) {
    return new GrafeasStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrafeasBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new GrafeasBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GrafeasFutureStub newFutureStub(io.grpc.Channel channel) {
    return new GrafeasFutureStub(channel);
  }

  /**
   *
   *
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
  public abstract static class GrafeasImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(
        io.grafeas.v1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(
        io.grafeas.v1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListOccurrencesMethodHelper(), responseObserver);
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
        io.grafeas.v1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteOccurrenceMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(
        io.grafeas.v1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateOccurrenceMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(
        io.grafeas.v1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateOccurrencesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateOccurrencesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(
        io.grafeas.v1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOccurrenceMethodHelper(), responseObserver);
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
        io.grafeas.v1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceNoteMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(
        io.grafeas.v1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNoteMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(
        io.grafeas.v1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNotesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(
        io.grafeas.v1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteNoteMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(
        io.grafeas.v1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNoteMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(
        io.grafeas.v1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateNotesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(
        io.grafeas.v1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateNoteMethodHelper(), responseObserver);
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
        io.grafeas.v1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNoteOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNoteOccurrencesMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetOccurrenceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1.GetOccurrenceRequest, io.grafeas.v1.Occurrence>(
                      this, METHODID_GET_OCCURRENCE)))
          .addMethod(
              getListOccurrencesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.ListOccurrencesRequest, io.grafeas.v1.ListOccurrencesResponse>(
                      this, METHODID_LIST_OCCURRENCES)))
          .addMethod(
              getDeleteOccurrenceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.DeleteOccurrenceRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_OCCURRENCE)))
          .addMethod(
              getCreateOccurrenceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.CreateOccurrenceRequest, io.grafeas.v1.Occurrence>(
                      this, METHODID_CREATE_OCCURRENCE)))
          .addMethod(
              getBatchCreateOccurrencesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.BatchCreateOccurrencesRequest,
                      io.grafeas.v1.BatchCreateOccurrencesResponse>(
                      this, METHODID_BATCH_CREATE_OCCURRENCES)))
          .addMethod(
              getUpdateOccurrenceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.UpdateOccurrenceRequest, io.grafeas.v1.Occurrence>(
                      this, METHODID_UPDATE_OCCURRENCE)))
          .addMethod(
              getGetOccurrenceNoteMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1.GetOccurrenceNoteRequest, io.grafeas.v1.Note>(
                      this, METHODID_GET_OCCURRENCE_NOTE)))
          .addMethod(
              getGetNoteMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1.GetNoteRequest, io.grafeas.v1.Note>(
                      this, METHODID_GET_NOTE)))
          .addMethod(
              getListNotesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.ListNotesRequest, io.grafeas.v1.ListNotesResponse>(
                      this, METHODID_LIST_NOTES)))
          .addMethod(
              getDeleteNoteMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1.DeleteNoteRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_NOTE)))
          .addMethod(
              getCreateNoteMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1.CreateNoteRequest, io.grafeas.v1.Note>(
                      this, METHODID_CREATE_NOTE)))
          .addMethod(
              getBatchCreateNotesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.BatchCreateNotesRequest,
                      io.grafeas.v1.BatchCreateNotesResponse>(this, METHODID_BATCH_CREATE_NOTES)))
          .addMethod(
              getUpdateNoteMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<io.grafeas.v1.UpdateNoteRequest, io.grafeas.v1.Note>(
                      this, METHODID_UPDATE_NOTE)))
          .addMethod(
              getListNoteOccurrencesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      io.grafeas.v1.ListNoteOccurrencesRequest,
                      io.grafeas.v1.ListNoteOccurrencesResponse>(
                      this, METHODID_LIST_NOTE_OCCURRENCES)))
          .build();
    }
  }

  /**
   *
   *
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
  public static final class GrafeasStub extends io.grpc.stub.AbstractStub<GrafeasStub> {
    private GrafeasStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrafeasStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(
        io.grafeas.v1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOccurrencesMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateOccurrencesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNoteMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(
        io.grafeas.v1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNotesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(
        io.grafeas.v1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteNoteMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(
        io.grafeas.v1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNoteMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(
        io.grafeas.v1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethodHelper(), getCallOptions()),
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
        io.grafeas.v1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateNoteMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
        io.grafeas.v1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1.ListNoteOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
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
  public static final class GrafeasBlockingStub
      extends io.grpc.stub.AbstractStub<GrafeasBlockingStub> {
    private GrafeasBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrafeasBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1.Occurrence getOccurrence(io.grafeas.v1.GetOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public io.grafeas.v1.ListOccurrencesResponse listOccurrences(
        io.grafeas.v1.ListOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListOccurrencesMethodHelper(), getCallOptions(), request);
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
        io.grafeas.v1.DeleteOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public io.grafeas.v1.Occurrence createOccurrence(
        io.grafeas.v1.CreateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public io.grafeas.v1.BatchCreateOccurrencesResponse batchCreateOccurrences(
        io.grafeas.v1.BatchCreateOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateOccurrencesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1.Occurrence updateOccurrence(
        io.grafeas.v1.UpdateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public io.grafeas.v1.Note getOccurrenceNote(io.grafeas.v1.GetOccurrenceNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public io.grafeas.v1.Note getNote(io.grafeas.v1.GetNoteRequest request) {
      return blockingUnaryCall(getChannel(), getGetNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public io.grafeas.v1.ListNotesResponse listNotes(io.grafeas.v1.ListNotesRequest request) {
      return blockingUnaryCall(getChannel(), getListNotesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNote(io.grafeas.v1.DeleteNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public io.grafeas.v1.Note createNote(io.grafeas.v1.CreateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public io.grafeas.v1.BatchCreateNotesResponse batchCreateNotes(
        io.grafeas.v1.BatchCreateNotesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateNotesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public io.grafeas.v1.Note updateNote(io.grafeas.v1.UpdateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateNoteMethodHelper(), getCallOptions(), request);
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
    public io.grafeas.v1.ListNoteOccurrencesResponse listNoteOccurrences(
        io.grafeas.v1.ListNoteOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNoteOccurrencesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
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
  public static final class GrafeasFutureStub extends io.grpc.stub.AbstractStub<GrafeasFutureStub> {
    private GrafeasFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrafeasFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GrafeasFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Occurrence>
        getOccurrence(io.grafeas.v1.GetOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.ListOccurrencesResponse>
        listOccurrences(io.grafeas.v1.ListOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOccurrencesMethodHelper(), getCallOptions()), request);
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
        deleteOccurrence(io.grafeas.v1.DeleteOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Occurrence>
        createOccurrence(io.grafeas.v1.CreateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1.BatchCreateOccurrencesResponse>
        batchCreateOccurrences(io.grafeas.v1.BatchCreateOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Occurrence>
        updateOccurrence(io.grafeas.v1.UpdateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> getOccurrenceNote(
        io.grafeas.v1.GetOccurrenceNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> getNote(
        io.grafeas.v1.GetNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.ListNotesResponse>
        listNotes(io.grafeas.v1.ListNotesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNotesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNote(
        io.grafeas.v1.DeleteNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> createNote(
        io.grafeas.v1.CreateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            io.grafeas.v1.BatchCreateNotesResponse>
        batchCreateNotes(io.grafeas.v1.BatchCreateNotesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1.Note> updateNote(
        io.grafeas.v1.UpdateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateNoteMethodHelper(), getCallOptions()), request);
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
            io.grafeas.v1.ListNoteOccurrencesResponse>
        listNoteOccurrences(io.grafeas.v1.ListNoteOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethodHelper(), getCallOptions()), request);
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

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.getOccurrence(
              (io.grafeas.v1.GetOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence>) responseObserver);
          break;
        case METHODID_LIST_OCCURRENCES:
          serviceImpl.listOccurrences(
              (io.grafeas.v1.ListOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.ListOccurrencesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_OCCURRENCE:
          serviceImpl.deleteOccurrence(
              (io.grafeas.v1.DeleteOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_OCCURRENCE:
          serviceImpl.createOccurrence(
              (io.grafeas.v1.CreateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_OCCURRENCES:
          serviceImpl.batchCreateOccurrences(
              (io.grafeas.v1.BatchCreateOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateOccurrencesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_OCCURRENCE:
          serviceImpl.updateOccurrence(
              (io.grafeas.v1.UpdateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Occurrence>) responseObserver);
          break;
        case METHODID_GET_OCCURRENCE_NOTE:
          serviceImpl.getOccurrenceNote(
              (io.grafeas.v1.GetOccurrenceNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_GET_NOTE:
          serviceImpl.getNote(
              (io.grafeas.v1.GetNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTES:
          serviceImpl.listNotes(
              (io.grafeas.v1.ListNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.ListNotesResponse>) responseObserver);
          break;
        case METHODID_DELETE_NOTE:
          serviceImpl.deleteNote(
              (io.grafeas.v1.DeleteNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_NOTE:
          serviceImpl.createNote(
              (io.grafeas.v1.CreateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_NOTES:
          serviceImpl.batchCreateNotes(
              (io.grafeas.v1.BatchCreateNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.BatchCreateNotesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NOTE:
          serviceImpl.updateNote(
              (io.grafeas.v1.UpdateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTE_OCCURRENCES:
          serviceImpl.listNoteOccurrences(
              (io.grafeas.v1.ListNoteOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1.ListNoteOccurrencesResponse>)
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

  private abstract static class GrafeasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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

  private static final class GrafeasFileDescriptorSupplier extends GrafeasBaseDescriptorSupplier {
    GrafeasFileDescriptorSupplier() {}
  }

  private static final class GrafeasMethodDescriptorSupplier extends GrafeasBaseDescriptorSupplier
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GrafeasFileDescriptorSupplier())
                      .addMethod(getGetOccurrenceMethodHelper())
                      .addMethod(getListOccurrencesMethodHelper())
                      .addMethod(getDeleteOccurrenceMethodHelper())
                      .addMethod(getCreateOccurrenceMethodHelper())
                      .addMethod(getBatchCreateOccurrencesMethodHelper())
                      .addMethod(getUpdateOccurrenceMethodHelper())
                      .addMethod(getGetOccurrenceNoteMethodHelper())
                      .addMethod(getGetNoteMethodHelper())
                      .addMethod(getListNotesMethodHelper())
                      .addMethod(getDeleteNoteMethodHelper())
                      .addMethod(getCreateNoteMethodHelper())
                      .addMethod(getBatchCreateNotesMethodHelper())
                      .addMethod(getUpdateNoteMethodHelper())
                      .addMethod(getListNoteOccurrencesMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
