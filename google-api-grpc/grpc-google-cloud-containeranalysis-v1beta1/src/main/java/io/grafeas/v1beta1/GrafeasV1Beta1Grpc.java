package io.grafeas.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/containeranalysis/v1beta1/grafeas/grafeas.proto")
public final class GrafeasV1Beta1Grpc {

  private GrafeasV1Beta1Grpc() {}

  public static final String SERVICE_NAME = "grafeas.v1beta1.GrafeasV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> METHOD_GET_OCCURRENCE = getGetOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getGetOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getGetOccurrenceMethod() {
    return getGetOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getGetOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence> getGetOccurrenceMethod;
    if ((getGetOccurrenceMethod = GrafeasV1Beta1Grpc.getGetOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetOccurrenceMethod = GrafeasV1Beta1Grpc.getGetOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getGetOccurrenceMethod = getGetOccurrenceMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.GetOccurrenceRequest, io.grafeas.v1beta1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "GetOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.GetOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Occurrence.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("GetOccurrence"))
                  .build();
          }
        }
     }
     return getGetOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListOccurrencesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListOccurrencesRequest,
      io.grafeas.v1beta1.ListOccurrencesResponse> METHOD_LIST_OCCURRENCES = getListOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListOccurrencesRequest,
      io.grafeas.v1beta1.ListOccurrencesResponse> getListOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListOccurrencesRequest,
      io.grafeas.v1beta1.ListOccurrencesResponse> getListOccurrencesMethod() {
    return getListOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListOccurrencesRequest,
      io.grafeas.v1beta1.ListOccurrencesResponse> getListOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListOccurrencesRequest, io.grafeas.v1beta1.ListOccurrencesResponse> getListOccurrencesMethod;
    if ((getListOccurrencesMethod = GrafeasV1Beta1Grpc.getListOccurrencesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getListOccurrencesMethod = GrafeasV1Beta1Grpc.getListOccurrencesMethod) == null) {
          GrafeasV1Beta1Grpc.getListOccurrencesMethod = getListOccurrencesMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.ListOccurrencesRequest, io.grafeas.v1beta1.ListOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "ListOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.ListOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.ListOccurrencesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("ListOccurrences"))
                  .build();
          }
        }
     }
     return getListOccurrencesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> METHOD_DELETE_OCCURRENCE = getDeleteOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethod() {
    return getDeleteOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty> getDeleteOccurrenceMethod;
    if ((getDeleteOccurrenceMethod = GrafeasV1Beta1Grpc.getDeleteOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getDeleteOccurrenceMethod = GrafeasV1Beta1Grpc.getDeleteOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getDeleteOccurrenceMethod = getDeleteOccurrenceMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.DeleteOccurrenceRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "DeleteOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.DeleteOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("DeleteOccurrence"))
                  .build();
          }
        }
     }
     return getDeleteOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> METHOD_CREATE_OCCURRENCE = getCreateOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getCreateOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getCreateOccurrenceMethod() {
    return getCreateOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getCreateOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence> getCreateOccurrenceMethod;
    if ((getCreateOccurrenceMethod = GrafeasV1Beta1Grpc.getCreateOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getCreateOccurrenceMethod = GrafeasV1Beta1Grpc.getCreateOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getCreateOccurrenceMethod = getCreateOccurrenceMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.CreateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "CreateOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.CreateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Occurrence.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("CreateOccurrence"))
                  .build();
          }
        }
     }
     return getCreateOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateOccurrencesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
      io.grafeas.v1beta1.BatchCreateOccurrencesResponse> METHOD_BATCH_CREATE_OCCURRENCES = getBatchCreateOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
      io.grafeas.v1beta1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
      io.grafeas.v1beta1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethod() {
    return getBatchCreateOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
      io.grafeas.v1beta1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateOccurrencesRequest, io.grafeas.v1beta1.BatchCreateOccurrencesResponse> getBatchCreateOccurrencesMethod;
    if ((getBatchCreateOccurrencesMethod = GrafeasV1Beta1Grpc.getBatchCreateOccurrencesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getBatchCreateOccurrencesMethod = GrafeasV1Beta1Grpc.getBatchCreateOccurrencesMethod) == null) {
          GrafeasV1Beta1Grpc.getBatchCreateOccurrencesMethod = getBatchCreateOccurrencesMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.BatchCreateOccurrencesRequest, io.grafeas.v1beta1.BatchCreateOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "BatchCreateOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.BatchCreateOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.BatchCreateOccurrencesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("BatchCreateOccurrences"))
                  .build();
          }
        }
     }
     return getBatchCreateOccurrencesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> METHOD_UPDATE_OCCURRENCE = getUpdateOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getUpdateOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getUpdateOccurrenceMethod() {
    return getUpdateOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateOccurrenceRequest,
      io.grafeas.v1beta1.Occurrence> getUpdateOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence> getUpdateOccurrenceMethod;
    if ((getUpdateOccurrenceMethod = GrafeasV1Beta1Grpc.getUpdateOccurrenceMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getUpdateOccurrenceMethod = GrafeasV1Beta1Grpc.getUpdateOccurrenceMethod) == null) {
          GrafeasV1Beta1Grpc.getUpdateOccurrenceMethod = getUpdateOccurrenceMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.UpdateOccurrenceRequest, io.grafeas.v1beta1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "UpdateOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.UpdateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Occurrence.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("UpdateOccurrence"))
                  .build();
          }
        }
     }
     return getUpdateOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOccurrenceNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceNoteRequest,
      io.grafeas.v1beta1.Note> METHOD_GET_OCCURRENCE_NOTE = getGetOccurrenceNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceNoteRequest,
      io.grafeas.v1beta1.Note> getGetOccurrenceNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceNoteRequest,
      io.grafeas.v1beta1.Note> getGetOccurrenceNoteMethod() {
    return getGetOccurrenceNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceNoteRequest,
      io.grafeas.v1beta1.Note> getGetOccurrenceNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note> getGetOccurrenceNoteMethod;
    if ((getGetOccurrenceNoteMethod = GrafeasV1Beta1Grpc.getGetOccurrenceNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetOccurrenceNoteMethod = GrafeasV1Beta1Grpc.getGetOccurrenceNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getGetOccurrenceNoteMethod = getGetOccurrenceNoteMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.GetOccurrenceNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "GetOccurrenceNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.GetOccurrenceNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("GetOccurrenceNote"))
                  .build();
          }
        }
     }
     return getGetOccurrenceNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest,
      io.grafeas.v1beta1.Note> METHOD_GET_NOTE = getGetNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest,
      io.grafeas.v1beta1.Note> getGetNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest,
      io.grafeas.v1beta1.Note> getGetNoteMethod() {
    return getGetNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest,
      io.grafeas.v1beta1.Note> getGetNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note> getGetNoteMethod;
    if ((getGetNoteMethod = GrafeasV1Beta1Grpc.getGetNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetNoteMethod = GrafeasV1Beta1Grpc.getGetNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getGetNoteMethod = getGetNoteMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.GetNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "GetNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.GetNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("GetNote"))
                  .build();
          }
        }
     }
     return getGetNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNotesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNotesRequest,
      io.grafeas.v1beta1.ListNotesResponse> METHOD_LIST_NOTES = getListNotesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNotesRequest,
      io.grafeas.v1beta1.ListNotesResponse> getListNotesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNotesRequest,
      io.grafeas.v1beta1.ListNotesResponse> getListNotesMethod() {
    return getListNotesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNotesRequest,
      io.grafeas.v1beta1.ListNotesResponse> getListNotesMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse> getListNotesMethod;
    if ((getListNotesMethod = GrafeasV1Beta1Grpc.getListNotesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getListNotesMethod = GrafeasV1Beta1Grpc.getListNotesMethod) == null) {
          GrafeasV1Beta1Grpc.getListNotesMethod = getListNotesMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.ListNotesRequest, io.grafeas.v1beta1.ListNotesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "ListNotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.ListNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.ListNotesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("ListNotes"))
                  .build();
          }
        }
     }
     return getListNotesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteNoteRequest,
      com.google.protobuf.Empty> METHOD_DELETE_NOTE = getDeleteNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethod() {
    return getDeleteNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty> getDeleteNoteMethod;
    if ((getDeleteNoteMethod = GrafeasV1Beta1Grpc.getDeleteNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getDeleteNoteMethod = GrafeasV1Beta1Grpc.getDeleteNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getDeleteNoteMethod = getDeleteNoteMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.DeleteNoteRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "DeleteNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.DeleteNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("DeleteNote"))
                  .build();
          }
        }
     }
     return getDeleteNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateNoteRequest,
      io.grafeas.v1beta1.Note> METHOD_CREATE_NOTE = getCreateNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateNoteRequest,
      io.grafeas.v1beta1.Note> getCreateNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateNoteRequest,
      io.grafeas.v1beta1.Note> getCreateNoteMethod() {
    return getCreateNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateNoteRequest,
      io.grafeas.v1beta1.Note> getCreateNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note> getCreateNoteMethod;
    if ((getCreateNoteMethod = GrafeasV1Beta1Grpc.getCreateNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getCreateNoteMethod = GrafeasV1Beta1Grpc.getCreateNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getCreateNoteMethod = getCreateNoteMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.CreateNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "CreateNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.CreateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("CreateNote"))
                  .build();
          }
        }
     }
     return getCreateNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateNotesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateNotesRequest,
      io.grafeas.v1beta1.BatchCreateNotesResponse> METHOD_BATCH_CREATE_NOTES = getBatchCreateNotesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateNotesRequest,
      io.grafeas.v1beta1.BatchCreateNotesResponse> getBatchCreateNotesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateNotesRequest,
      io.grafeas.v1beta1.BatchCreateNotesResponse> getBatchCreateNotesMethod() {
    return getBatchCreateNotesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateNotesRequest,
      io.grafeas.v1beta1.BatchCreateNotesResponse> getBatchCreateNotesMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.BatchCreateNotesRequest, io.grafeas.v1beta1.BatchCreateNotesResponse> getBatchCreateNotesMethod;
    if ((getBatchCreateNotesMethod = GrafeasV1Beta1Grpc.getBatchCreateNotesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getBatchCreateNotesMethod = GrafeasV1Beta1Grpc.getBatchCreateNotesMethod) == null) {
          GrafeasV1Beta1Grpc.getBatchCreateNotesMethod = getBatchCreateNotesMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.BatchCreateNotesRequest, io.grafeas.v1beta1.BatchCreateNotesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "BatchCreateNotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.BatchCreateNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.BatchCreateNotesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("BatchCreateNotes"))
                  .build();
          }
        }
     }
     return getBatchCreateNotesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateNoteRequest,
      io.grafeas.v1beta1.Note> METHOD_UPDATE_NOTE = getUpdateNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateNoteRequest,
      io.grafeas.v1beta1.Note> getUpdateNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateNoteRequest,
      io.grafeas.v1beta1.Note> getUpdateNoteMethod() {
    return getUpdateNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateNoteRequest,
      io.grafeas.v1beta1.Note> getUpdateNoteMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note> getUpdateNoteMethod;
    if ((getUpdateNoteMethod = GrafeasV1Beta1Grpc.getUpdateNoteMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getUpdateNoteMethod = GrafeasV1Beta1Grpc.getUpdateNoteMethod) == null) {
          GrafeasV1Beta1Grpc.getUpdateNoteMethod = getUpdateNoteMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.UpdateNoteRequest, io.grafeas.v1beta1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "UpdateNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.UpdateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("UpdateNote"))
                  .build();
          }
        }
     }
     return getUpdateNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNoteOccurrencesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNoteOccurrencesRequest,
      io.grafeas.v1beta1.ListNoteOccurrencesResponse> METHOD_LIST_NOTE_OCCURRENCES = getListNoteOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNoteOccurrencesRequest,
      io.grafeas.v1beta1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNoteOccurrencesRequest,
      io.grafeas.v1beta1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod() {
    return getListNoteOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNoteOccurrencesRequest,
      io.grafeas.v1beta1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.ListNoteOccurrencesRequest, io.grafeas.v1beta1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod;
    if ((getListNoteOccurrencesMethod = GrafeasV1Beta1Grpc.getListNoteOccurrencesMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getListNoteOccurrencesMethod = GrafeasV1Beta1Grpc.getListNoteOccurrencesMethod) == null) {
          GrafeasV1Beta1Grpc.getListNoteOccurrencesMethod = getListNoteOccurrencesMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.ListNoteOccurrencesRequest, io.grafeas.v1beta1.ListNoteOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "ListNoteOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.ListNoteOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.ListNoteOccurrencesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("ListNoteOccurrences"))
                  .build();
          }
        }
     }
     return getListNoteOccurrencesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetVulnerabilityOccurrencesSummaryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
      io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> METHOD_GET_VULNERABILITY_OCCURRENCES_SUMMARY = getGetVulnerabilityOccurrencesSummaryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
      io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> getGetVulnerabilityOccurrencesSummaryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
      io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> getGetVulnerabilityOccurrencesSummaryMethod() {
    return getGetVulnerabilityOccurrencesSummaryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
      io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> getGetVulnerabilityOccurrencesSummaryMethodHelper() {
    io.grpc.MethodDescriptor<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest, io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> getGetVulnerabilityOccurrencesSummaryMethod;
    if ((getGetVulnerabilityOccurrencesSummaryMethod = GrafeasV1Beta1Grpc.getGetVulnerabilityOccurrencesSummaryMethod) == null) {
      synchronized (GrafeasV1Beta1Grpc.class) {
        if ((getGetVulnerabilityOccurrencesSummaryMethod = GrafeasV1Beta1Grpc.getGetVulnerabilityOccurrencesSummaryMethod) == null) {
          GrafeasV1Beta1Grpc.getGetVulnerabilityOccurrencesSummaryMethod = getGetVulnerabilityOccurrencesSummaryMethod = 
              io.grpc.MethodDescriptor.<io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest, io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1", "GetVulnerabilityOccurrencesSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grafeas.v1beta1.VulnerabilityOccurrencesSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new GrafeasV1Beta1MethodDescriptorSupplier("GetVulnerabilityOccurrencesSummary"))
                  .build();
          }
        }
     }
     return getGetVulnerabilityOccurrencesSummaryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrafeasV1Beta1Stub newStub(io.grpc.Channel channel) {
    return new GrafeasV1Beta1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrafeasV1Beta1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrafeasV1Beta1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrafeasV1Beta1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrafeasV1Beta1FutureStub(channel);
  }

  /**
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
  public static abstract class GrafeasV1Beta1ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(io.grafeas.v1beta1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(io.grafeas.v1beta1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListOccurrencesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public void deleteOccurrence(io.grafeas.v1beta1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(io.grafeas.v1beta1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(io.grafeas.v1beta1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateOccurrencesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(io.grafeas.v1beta1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public void getOccurrenceNote(io.grafeas.v1beta1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(io.grafeas.v1beta1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(io.grafeas.v1beta1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNotesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(io.grafeas.v1beta1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(io.grafeas.v1beta1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(io.grafeas.v1beta1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateNotesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(io.grafeas.v1beta1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public void listNoteOccurrences(io.grafeas.v1beta1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNoteOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNoteOccurrencesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public void getVulnerabilityOccurrencesSummary(io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVulnerabilityOccurrencesSummaryMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.GetOccurrenceRequest,
                io.grafeas.v1beta1.Occurrence>(
                  this, METHODID_GET_OCCURRENCE)))
          .addMethod(
            getListOccurrencesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.ListOccurrencesRequest,
                io.grafeas.v1beta1.ListOccurrencesResponse>(
                  this, METHODID_LIST_OCCURRENCES)))
          .addMethod(
            getDeleteOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.DeleteOccurrenceRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_OCCURRENCE)))
          .addMethod(
            getCreateOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.CreateOccurrenceRequest,
                io.grafeas.v1beta1.Occurrence>(
                  this, METHODID_CREATE_OCCURRENCE)))
          .addMethod(
            getBatchCreateOccurrencesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.BatchCreateOccurrencesRequest,
                io.grafeas.v1beta1.BatchCreateOccurrencesResponse>(
                  this, METHODID_BATCH_CREATE_OCCURRENCES)))
          .addMethod(
            getUpdateOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.UpdateOccurrenceRequest,
                io.grafeas.v1beta1.Occurrence>(
                  this, METHODID_UPDATE_OCCURRENCE)))
          .addMethod(
            getGetOccurrenceNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.GetOccurrenceNoteRequest,
                io.grafeas.v1beta1.Note>(
                  this, METHODID_GET_OCCURRENCE_NOTE)))
          .addMethod(
            getGetNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.GetNoteRequest,
                io.grafeas.v1beta1.Note>(
                  this, METHODID_GET_NOTE)))
          .addMethod(
            getListNotesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.ListNotesRequest,
                io.grafeas.v1beta1.ListNotesResponse>(
                  this, METHODID_LIST_NOTES)))
          .addMethod(
            getDeleteNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.DeleteNoteRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_NOTE)))
          .addMethod(
            getCreateNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.CreateNoteRequest,
                io.grafeas.v1beta1.Note>(
                  this, METHODID_CREATE_NOTE)))
          .addMethod(
            getBatchCreateNotesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.BatchCreateNotesRequest,
                io.grafeas.v1beta1.BatchCreateNotesResponse>(
                  this, METHODID_BATCH_CREATE_NOTES)))
          .addMethod(
            getUpdateNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.UpdateNoteRequest,
                io.grafeas.v1beta1.Note>(
                  this, METHODID_UPDATE_NOTE)))
          .addMethod(
            getListNoteOccurrencesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.ListNoteOccurrencesRequest,
                io.grafeas.v1beta1.ListNoteOccurrencesResponse>(
                  this, METHODID_LIST_NOTE_OCCURRENCES)))
          .addMethod(
            getGetVulnerabilityOccurrencesSummaryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest,
                io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>(
                  this, METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY)))
          .build();
    }
  }

  /**
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
  public static final class GrafeasV1Beta1Stub extends io.grpc.stub.AbstractStub<GrafeasV1Beta1Stub> {
    private GrafeasV1Beta1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrafeasV1Beta1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasV1Beta1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrafeasV1Beta1Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public void getOccurrence(io.grafeas.v1beta1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public void listOccurrences(io.grafeas.v1beta1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOccurrencesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public void deleteOccurrence(io.grafeas.v1beta1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public void createOccurrence(io.grafeas.v1beta1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public void batchCreateOccurrences(io.grafeas.v1beta1.BatchCreateOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public void updateOccurrence(io.grafeas.v1beta1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public void getOccurrenceNote(io.grafeas.v1beta1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public void getNote(io.grafeas.v1beta1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public void listNotes(io.grafeas.v1beta1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNotesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public void deleteNote(io.grafeas.v1beta1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public void createNote(io.grafeas.v1beta1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public void batchCreateNotes(io.grafeas.v1beta1.BatchCreateNotesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public void updateNote(io.grafeas.v1beta1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public void listNoteOccurrences(io.grafeas.v1beta1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNoteOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public void getVulnerabilityOccurrencesSummary(io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVulnerabilityOccurrencesSummaryMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
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
  public static final class GrafeasV1Beta1BlockingStub extends io.grpc.stub.AbstractStub<GrafeasV1Beta1BlockingStub> {
    private GrafeasV1Beta1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrafeasV1Beta1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasV1Beta1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrafeasV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1beta1.Occurrence getOccurrence(io.grafeas.v1beta1.GetOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public io.grafeas.v1beta1.ListOccurrencesResponse listOccurrences(io.grafeas.v1beta1.ListOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListOccurrencesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteOccurrence(io.grafeas.v1beta1.DeleteOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public io.grafeas.v1beta1.Occurrence createOccurrence(io.grafeas.v1beta1.CreateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public io.grafeas.v1beta1.BatchCreateOccurrencesResponse batchCreateOccurrences(io.grafeas.v1beta1.BatchCreateOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateOccurrencesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public io.grafeas.v1beta1.Occurrence updateOccurrence(io.grafeas.v1beta1.UpdateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public io.grafeas.v1beta1.Note getOccurrenceNote(io.grafeas.v1beta1.GetOccurrenceNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public io.grafeas.v1beta1.Note getNote(io.grafeas.v1beta1.GetNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public io.grafeas.v1beta1.ListNotesResponse listNotes(io.grafeas.v1beta1.ListNotesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNotesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNote(io.grafeas.v1beta1.DeleteNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public io.grafeas.v1beta1.Note createNote(io.grafeas.v1beta1.CreateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public io.grafeas.v1beta1.BatchCreateNotesResponse batchCreateNotes(io.grafeas.v1beta1.BatchCreateNotesRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateNotesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public io.grafeas.v1beta1.Note updateNote(io.grafeas.v1beta1.UpdateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public io.grafeas.v1beta1.ListNoteOccurrencesResponse listNoteOccurrences(io.grafeas.v1beta1.ListNoteOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNoteOccurrencesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public io.grafeas.v1beta1.VulnerabilityOccurrencesSummary getVulnerabilityOccurrencesSummary(io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetVulnerabilityOccurrencesSummaryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
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
  public static final class GrafeasV1Beta1FutureStub extends io.grpc.stub.AbstractStub<GrafeasV1Beta1FutureStub> {
    private GrafeasV1Beta1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrafeasV1Beta1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrafeasV1Beta1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrafeasV1Beta1FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Occurrence> getOccurrence(
        io.grafeas.v1beta1.GetOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists occurrences for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.ListOccurrencesResponse> listOccurrences(
        io.grafeas.v1beta1.ListOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOccurrencesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified occurrence. For example, use this method to delete an
     * occurrence when the occurrence is no longer applicable for the given
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteOccurrence(
        io.grafeas.v1beta1.DeleteOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Occurrence> createOccurrence(
        io.grafeas.v1beta1.CreateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates new occurrences in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.BatchCreateOccurrencesResponse> batchCreateOccurrences(
        io.grafeas.v1beta1.BatchCreateOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateOccurrencesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Occurrence> updateOccurrence(
        io.grafeas.v1beta1.UpdateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the note attached to the specified occurrence. Consumer projects can
     * use this method to get a note that belongs to a provider project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> getOccurrenceNote(
        io.grafeas.v1beta1.GetOccurrenceNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> getNote(
        io.grafeas.v1beta1.GetNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists notes for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.ListNotesResponse> listNotes(
        io.grafeas.v1beta1.ListNotesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNotesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNote(
        io.grafeas.v1beta1.DeleteNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> createNote(
        io.grafeas.v1beta1.CreateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates new notes in batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.BatchCreateNotesResponse> batchCreateNotes(
        io.grafeas.v1beta1.BatchCreateNotesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateNotesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.Note> updateNote(
        io.grafeas.v1beta1.UpdateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists occurrences referencing the specified note. Provider projects can use
     * this method to get all occurrences across consumer projects referencing the
     * specified note.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.ListNoteOccurrencesResponse> listNoteOccurrences(
        io.grafeas.v1beta1.ListNoteOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary> getVulnerabilityOccurrencesSummary(
        io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVulnerabilityOccurrencesSummaryMethodHelper(), getCallOptions()), request);
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

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.getOccurrence((io.grafeas.v1beta1.GetOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence>) responseObserver);
          break;
        case METHODID_LIST_OCCURRENCES:
          serviceImpl.listOccurrences((io.grafeas.v1beta1.ListOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListOccurrencesResponse>) responseObserver);
          break;
        case METHODID_DELETE_OCCURRENCE:
          serviceImpl.deleteOccurrence((io.grafeas.v1beta1.DeleteOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_OCCURRENCE:
          serviceImpl.createOccurrence((io.grafeas.v1beta1.CreateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_OCCURRENCES:
          serviceImpl.batchCreateOccurrences((io.grafeas.v1beta1.BatchCreateOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateOccurrencesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_OCCURRENCE:
          serviceImpl.updateOccurrence((io.grafeas.v1beta1.UpdateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Occurrence>) responseObserver);
          break;
        case METHODID_GET_OCCURRENCE_NOTE:
          serviceImpl.getOccurrenceNote((io.grafeas.v1beta1.GetOccurrenceNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_GET_NOTE:
          serviceImpl.getNote((io.grafeas.v1beta1.GetNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTES:
          serviceImpl.listNotes((io.grafeas.v1beta1.ListNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNotesResponse>) responseObserver);
          break;
        case METHODID_DELETE_NOTE:
          serviceImpl.deleteNote((io.grafeas.v1beta1.DeleteNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_NOTE:
          serviceImpl.createNote((io.grafeas.v1beta1.CreateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_NOTES:
          serviceImpl.batchCreateNotes((io.grafeas.v1beta1.BatchCreateNotesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.BatchCreateNotesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_NOTE:
          serviceImpl.updateNote((io.grafeas.v1beta1.UpdateNoteRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTE_OCCURRENCES:
          serviceImpl.listNoteOccurrences((io.grafeas.v1beta1.ListNoteOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.ListNoteOccurrencesResponse>) responseObserver);
          break;
        case METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY:
          serviceImpl.getVulnerabilityOccurrencesSummary((io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest) request,
              (io.grpc.stub.StreamObserver<io.grafeas.v1beta1.VulnerabilityOccurrencesSummary>) responseObserver);
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

  private static abstract class GrafeasV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrafeasV1Beta1FileDescriptorSupplier())
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
              .addMethod(getGetVulnerabilityOccurrencesSummaryMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
