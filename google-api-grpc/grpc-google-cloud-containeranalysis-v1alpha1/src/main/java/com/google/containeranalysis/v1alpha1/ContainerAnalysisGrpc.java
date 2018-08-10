package com.google.containeranalysis.v1alpha1;

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
 * Retrieves the results of vulnerability scanning of cloud components such as
 * container images. The Container Analysis API is an implementation of the
 * [Grafeas](grafeas.io) API.
 * The vulnerability results are stored as a series of Occurrences.
 * An `Occurrence` contains information about a specific vulnerability in a
 * resource. An `Occurrence` references a `Note`. A `Note` contains details
 * about the vulnerability and is stored in a stored in a separate project.
 * Multiple `Occurrences` can reference the same `Note`. For example, an SSL
 * vulnerability could affect multiple packages in an image. In this case,
 * there would be one `Note` for the vulnerability and an `Occurrence` for
 * each package with the vulnerability referencing that `Note`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/containeranalysis/v1alpha1/containeranalysis.proto")
public final class ContainerAnalysisGrpc {

  private ContainerAnalysisGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> METHOD_GET_OCCURRENCE = getGetOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getGetOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getGetOccurrenceMethod() {
    return getGetOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getGetOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceRequest, com.google.containeranalysis.v1alpha1.Occurrence> getGetOccurrenceMethod;
    if ((getGetOccurrenceMethod = ContainerAnalysisGrpc.getGetOccurrenceMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetOccurrenceMethod = ContainerAnalysisGrpc.getGetOccurrenceMethod) == null) {
          ContainerAnalysisGrpc.getGetOccurrenceMethod = getGetOccurrenceMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.GetOccurrenceRequest, com.google.containeranalysis.v1alpha1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "GetOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.GetOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Occurrence.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("GetOccurrence"))
                  .build();
          }
        }
     }
     return getGetOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListOccurrencesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> METHOD_LIST_OCCURRENCES = getListOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> getListOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> getListOccurrencesMethod() {
    return getListOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> getListOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListOccurrencesRequest, com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> getListOccurrencesMethod;
    if ((getListOccurrencesMethod = ContainerAnalysisGrpc.getListOccurrencesMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getListOccurrencesMethod = ContainerAnalysisGrpc.getListOccurrencesMethod) == null) {
          ContainerAnalysisGrpc.getListOccurrencesMethod = getListOccurrencesMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.ListOccurrencesRequest, com.google.containeranalysis.v1alpha1.ListOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "ListOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListOccurrencesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("ListOccurrences"))
                  .build();
          }
        }
     }
     return getListOccurrencesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> METHOD_DELETE_OCCURRENCE = getDeleteOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethod() {
    return getDeleteOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest,
      com.google.protobuf.Empty> getDeleteOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest, com.google.protobuf.Empty> getDeleteOccurrenceMethod;
    if ((getDeleteOccurrenceMethod = ContainerAnalysisGrpc.getDeleteOccurrenceMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getDeleteOccurrenceMethod = ContainerAnalysisGrpc.getDeleteOccurrenceMethod) == null) {
          ContainerAnalysisGrpc.getDeleteOccurrenceMethod = getDeleteOccurrenceMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "DeleteOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("DeleteOccurrence"))
                  .build();
          }
        }
     }
     return getDeleteOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> METHOD_CREATE_OCCURRENCE = getCreateOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getCreateOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getCreateOccurrenceMethod() {
    return getCreateOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getCreateOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest, com.google.containeranalysis.v1alpha1.Occurrence> getCreateOccurrenceMethod;
    if ((getCreateOccurrenceMethod = ContainerAnalysisGrpc.getCreateOccurrenceMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getCreateOccurrenceMethod = ContainerAnalysisGrpc.getCreateOccurrenceMethod) == null) {
          ContainerAnalysisGrpc.getCreateOccurrenceMethod = getCreateOccurrenceMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest, com.google.containeranalysis.v1alpha1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "CreateOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Occurrence.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("CreateOccurrence"))
                  .build();
          }
        }
     }
     return getCreateOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateOccurrenceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> METHOD_UPDATE_OCCURRENCE = getUpdateOccurrenceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getUpdateOccurrenceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getUpdateOccurrenceMethod() {
    return getUpdateOccurrenceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest,
      com.google.containeranalysis.v1alpha1.Occurrence> getUpdateOccurrenceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest, com.google.containeranalysis.v1alpha1.Occurrence> getUpdateOccurrenceMethod;
    if ((getUpdateOccurrenceMethod = ContainerAnalysisGrpc.getUpdateOccurrenceMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getUpdateOccurrenceMethod = ContainerAnalysisGrpc.getUpdateOccurrenceMethod) == null) {
          ContainerAnalysisGrpc.getUpdateOccurrenceMethod = getUpdateOccurrenceMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest, com.google.containeranalysis.v1alpha1.Occurrence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "UpdateOccurrence"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Occurrence.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("UpdateOccurrence"))
                  .build();
          }
        }
     }
     return getUpdateOccurrenceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOccurrenceNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> METHOD_GET_OCCURRENCE_NOTE = getGetOccurrenceNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getGetOccurrenceNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getGetOccurrenceNoteMethod() {
    return getGetOccurrenceNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getGetOccurrenceNoteMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest, com.google.containeranalysis.v1alpha1.Note> getGetOccurrenceNoteMethod;
    if ((getGetOccurrenceNoteMethod = ContainerAnalysisGrpc.getGetOccurrenceNoteMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetOccurrenceNoteMethod = ContainerAnalysisGrpc.getGetOccurrenceNoteMethod) == null) {
          ContainerAnalysisGrpc.getGetOccurrenceNoteMethod = getGetOccurrenceNoteMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest, com.google.containeranalysis.v1alpha1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "GetOccurrenceNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("GetOccurrenceNote"))
                  .build();
          }
        }
     }
     return getGetOccurrenceNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> METHOD_GET_NOTE = getGetNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getGetNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getGetNoteMethod() {
    return getGetNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getGetNoteMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetNoteRequest, com.google.containeranalysis.v1alpha1.Note> getGetNoteMethod;
    if ((getGetNoteMethod = ContainerAnalysisGrpc.getGetNoteMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetNoteMethod = ContainerAnalysisGrpc.getGetNoteMethod) == null) {
          ContainerAnalysisGrpc.getGetNoteMethod = getGetNoteMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.GetNoteRequest, com.google.containeranalysis.v1alpha1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "GetNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.GetNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("GetNote"))
                  .build();
          }
        }
     }
     return getGetNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNotesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNotesRequest,
      com.google.containeranalysis.v1alpha1.ListNotesResponse> METHOD_LIST_NOTES = getListNotesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNotesRequest,
      com.google.containeranalysis.v1alpha1.ListNotesResponse> getListNotesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNotesRequest,
      com.google.containeranalysis.v1alpha1.ListNotesResponse> getListNotesMethod() {
    return getListNotesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNotesRequest,
      com.google.containeranalysis.v1alpha1.ListNotesResponse> getListNotesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNotesRequest, com.google.containeranalysis.v1alpha1.ListNotesResponse> getListNotesMethod;
    if ((getListNotesMethod = ContainerAnalysisGrpc.getListNotesMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getListNotesMethod = ContainerAnalysisGrpc.getListNotesMethod) == null) {
          ContainerAnalysisGrpc.getListNotesMethod = getListNotesMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.ListNotesRequest, com.google.containeranalysis.v1alpha1.ListNotesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "ListNotes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListNotesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("ListNotes"))
                  .build();
          }
        }
     }
     return getListNotesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteNoteRequest,
      com.google.protobuf.Empty> METHOD_DELETE_NOTE = getDeleteNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethod() {
    return getDeleteNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteNoteRequest,
      com.google.protobuf.Empty> getDeleteNoteMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.DeleteNoteRequest, com.google.protobuf.Empty> getDeleteNoteMethod;
    if ((getDeleteNoteMethod = ContainerAnalysisGrpc.getDeleteNoteMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getDeleteNoteMethod = ContainerAnalysisGrpc.getDeleteNoteMethod) == null) {
          ContainerAnalysisGrpc.getDeleteNoteMethod = getDeleteNoteMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.DeleteNoteRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "DeleteNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.DeleteNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("DeleteNote"))
                  .build();
          }
        }
     }
     return getDeleteNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> METHOD_CREATE_NOTE = getCreateNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getCreateNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getCreateNoteMethod() {
    return getCreateNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getCreateNoteMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateNoteRequest, com.google.containeranalysis.v1alpha1.Note> getCreateNoteMethod;
    if ((getCreateNoteMethod = ContainerAnalysisGrpc.getCreateNoteMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getCreateNoteMethod = ContainerAnalysisGrpc.getCreateNoteMethod) == null) {
          ContainerAnalysisGrpc.getCreateNoteMethod = getCreateNoteMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.CreateNoteRequest, com.google.containeranalysis.v1alpha1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "CreateNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.CreateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("CreateNote"))
                  .build();
          }
        }
     }
     return getCreateNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateNoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> METHOD_UPDATE_NOTE = getUpdateNoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getUpdateNoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getUpdateNoteMethod() {
    return getUpdateNoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateNoteRequest,
      com.google.containeranalysis.v1alpha1.Note> getUpdateNoteMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateNoteRequest, com.google.containeranalysis.v1alpha1.Note> getUpdateNoteMethod;
    if ((getUpdateNoteMethod = ContainerAnalysisGrpc.getUpdateNoteMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getUpdateNoteMethod = ContainerAnalysisGrpc.getUpdateNoteMethod) == null) {
          ContainerAnalysisGrpc.getUpdateNoteMethod = getUpdateNoteMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.UpdateNoteRequest, com.google.containeranalysis.v1alpha1.Note>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "UpdateNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.UpdateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.Note.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("UpdateNote"))
                  .build();
          }
        }
     }
     return getUpdateNoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListNoteOccurrencesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> METHOD_LIST_NOTE_OCCURRENCES = getListNoteOccurrencesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod() {
    return getListNoteOccurrencesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest,
      com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest, com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> getListNoteOccurrencesMethod;
    if ((getListNoteOccurrencesMethod = ContainerAnalysisGrpc.getListNoteOccurrencesMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getListNoteOccurrencesMethod = ContainerAnalysisGrpc.getListNoteOccurrencesMethod) == null) {
          ContainerAnalysisGrpc.getListNoteOccurrencesMethod = getListNoteOccurrencesMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest, com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "ListNoteOccurrences"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("ListNoteOccurrences"))
                  .build();
          }
        }
     }
     return getListNoteOccurrencesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetVulnzOccurrencesSummaryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest,
      com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> METHOD_GET_VULNZ_OCCURRENCES_SUMMARY = getGetVulnzOccurrencesSummaryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest,
      com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> getGetVulnzOccurrencesSummaryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest,
      com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> getGetVulnzOccurrencesSummaryMethod() {
    return getGetVulnzOccurrencesSummaryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest,
      com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> getGetVulnzOccurrencesSummaryMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest, com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> getGetVulnzOccurrencesSummaryMethod;
    if ((getGetVulnzOccurrencesSummaryMethod = ContainerAnalysisGrpc.getGetVulnzOccurrencesSummaryMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetVulnzOccurrencesSummaryMethod = ContainerAnalysisGrpc.getGetVulnzOccurrencesSummaryMethod) == null) {
          ContainerAnalysisGrpc.getGetVulnzOccurrencesSummaryMethod = getGetVulnzOccurrencesSummaryMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest, com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "GetVulnzOccurrencesSummary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("GetVulnzOccurrencesSummary"))
                  .build();
          }
        }
     }
     return getGetVulnzOccurrencesSummaryMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = ContainerAnalysisGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getSetIamPolicyMethod = ContainerAnalysisGrpc.getSetIamPolicyMethod) == null) {
          ContainerAnalysisGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("SetIamPolicy"))
                  .build();
          }
        }
     }
     return getSetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = ContainerAnalysisGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetIamPolicyMethod = ContainerAnalysisGrpc.getGetIamPolicyMethod) == null) {
          ContainerAnalysisGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("GetIamPolicy"))
                  .build();
          }
        }
     }
     return getGetIamPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = ContainerAnalysisGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getTestIamPermissionsMethod = ContainerAnalysisGrpc.getTestIamPermissionsMethod) == null) {
          ContainerAnalysisGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod = 
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("TestIamPermissions"))
                  .build();
          }
        }
     }
     return getTestIamPermissionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateOperationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOperationRequest,
      com.google.longrunning.Operation> METHOD_CREATE_OPERATION = getCreateOperationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOperationRequest,
      com.google.longrunning.Operation> getCreateOperationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOperationRequest,
      com.google.longrunning.Operation> getCreateOperationMethod() {
    return getCreateOperationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOperationRequest,
      com.google.longrunning.Operation> getCreateOperationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.CreateOperationRequest, com.google.longrunning.Operation> getCreateOperationMethod;
    if ((getCreateOperationMethod = ContainerAnalysisGrpc.getCreateOperationMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getCreateOperationMethod = ContainerAnalysisGrpc.getCreateOperationMethod) == null) {
          ContainerAnalysisGrpc.getCreateOperationMethod = getCreateOperationMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.CreateOperationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "CreateOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.CreateOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("CreateOperation"))
                  .build();
          }
        }
     }
     return getCreateOperationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateOperationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOperationRequest,
      com.google.longrunning.Operation> METHOD_UPDATE_OPERATION = getUpdateOperationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOperationRequest,
      com.google.longrunning.Operation> getUpdateOperationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOperationRequest,
      com.google.longrunning.Operation> getUpdateOperationMethod() {
    return getUpdateOperationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOperationRequest,
      com.google.longrunning.Operation> getUpdateOperationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateOperationRequest, com.google.longrunning.Operation> getUpdateOperationMethod;
    if ((getUpdateOperationMethod = ContainerAnalysisGrpc.getUpdateOperationMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getUpdateOperationMethod = ContainerAnalysisGrpc.getUpdateOperationMethod) == null) {
          ContainerAnalysisGrpc.getUpdateOperationMethod = getUpdateOperationMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.UpdateOperationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "UpdateOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.UpdateOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("UpdateOperation"))
                  .build();
          }
        }
     }
     return getUpdateOperationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetScanConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> METHOD_GET_SCAN_CONFIG = getGetScanConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> getGetScanConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> getGetScanConfigMethod() {
    return getGetScanConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> getGetScanConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.GetScanConfigRequest, com.google.containeranalysis.v1alpha1.ScanConfig> getGetScanConfigMethod;
    if ((getGetScanConfigMethod = ContainerAnalysisGrpc.getGetScanConfigMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetScanConfigMethod = ContainerAnalysisGrpc.getGetScanConfigMethod) == null) {
          ContainerAnalysisGrpc.getGetScanConfigMethod = getGetScanConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.GetScanConfigRequest, com.google.containeranalysis.v1alpha1.ScanConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "GetScanConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.GetScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ScanConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("GetScanConfig"))
                  .build();
          }
        }
     }
     return getGetScanConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListScanConfigsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListScanConfigsRequest,
      com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> METHOD_LIST_SCAN_CONFIGS = getListScanConfigsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListScanConfigsRequest,
      com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> getListScanConfigsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListScanConfigsRequest,
      com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> getListScanConfigsMethod() {
    return getListScanConfigsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListScanConfigsRequest,
      com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> getListScanConfigsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.ListScanConfigsRequest, com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> getListScanConfigsMethod;
    if ((getListScanConfigsMethod = ContainerAnalysisGrpc.getListScanConfigsMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getListScanConfigsMethod = ContainerAnalysisGrpc.getListScanConfigsMethod) == null) {
          ContainerAnalysisGrpc.getListScanConfigsMethod = getListScanConfigsMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.ListScanConfigsRequest, com.google.containeranalysis.v1alpha1.ListScanConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "ListScanConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListScanConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ListScanConfigsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("ListScanConfigs"))
                  .build();
          }
        }
     }
     return getListScanConfigsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateScanConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> METHOD_UPDATE_SCAN_CONFIG = getUpdateScanConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> getUpdateScanConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> getUpdateScanConfigMethod() {
    return getUpdateScanConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest,
      com.google.containeranalysis.v1alpha1.ScanConfig> getUpdateScanConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest, com.google.containeranalysis.v1alpha1.ScanConfig> getUpdateScanConfigMethod;
    if ((getUpdateScanConfigMethod = ContainerAnalysisGrpc.getUpdateScanConfigMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getUpdateScanConfigMethod = ContainerAnalysisGrpc.getUpdateScanConfigMethod) == null) {
          ContainerAnalysisGrpc.getUpdateScanConfigMethod = getUpdateScanConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest, com.google.containeranalysis.v1alpha1.ScanConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis", "UpdateScanConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.containeranalysis.v1alpha1.ScanConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new ContainerAnalysisMethodDescriptorSupplier("UpdateScanConfig"))
                  .build();
          }
        }
     }
     return getUpdateScanConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContainerAnalysisStub newStub(io.grpc.Channel channel) {
    return new ContainerAnalysisStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContainerAnalysisBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ContainerAnalysisBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContainerAnalysisFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ContainerAnalysisFutureStub(channel);
  }

  /**
   * <pre>
   * Retrieves the results of vulnerability scanning of cloud components such as
   * container images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
   * The vulnerability results are stored as a series of Occurrences.
   * An `Occurrence` contains information about a specific vulnerability in a
   * resource. An `Occurrence` references a `Note`. A `Note` contains details
   * about the vulnerability and is stored in a stored in a separate project.
   * Multiple `Occurrences` can reference the same `Note`. For example, an SSL
   * vulnerability could affect multiple packages in an image. In this case,
   * there would be one `Note` for the vulnerability and an `Occurrence` for
   * each package with the vulnerability referencing that `Note`.
   * </pre>
   */
  public static abstract class ContainerAnalysisImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the requested `Occurrence`.
     * </pre>
     */
    public void getOccurrence(com.google.containeranalysis.v1alpha1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists active `Occurrences` for a given project matching the filters.
     * </pre>
     */
    public void listOccurrences(com.google.containeranalysis.v1alpha1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListOccurrencesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the given `Occurrence` from the system. Use this when
     * an `Occurrence` is no longer applicable for the given resource.
     * </pre>
     */
    public void deleteOccurrence(com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new `Occurrence`. Use this method to create `Occurrences`
     * for a resource.
     * </pre>
     */
    public void createOccurrence(com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing occurrence.
     * </pre>
     */
    public void updateOccurrence(com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOccurrenceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the `Note` attached to the given `Occurrence`.
     * </pre>
     */
    public void getOccurrenceNote(com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOccurrenceNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns the requested `Note`.
     * </pre>
     */
    public void getNote(com.google.containeranalysis.v1alpha1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists all `Notes` for a given project.
     * </pre>
     */
    public void listNotes(com.google.containeranalysis.v1alpha1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListNotesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNotesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the given `Note` from the system.
     * </pre>
     */
    public void deleteNote(com.google.containeranalysis.v1alpha1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new `Note`.
     * </pre>
     */
    public void createNote(com.google.containeranalysis.v1alpha1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing `Note`.
     * </pre>
     */
    public void updateNote(com.google.containeranalysis.v1alpha1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateNoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists `Occurrences` referencing the specified `Note`. Use this method to
     * get all occurrences referencing your `Note` across all your customer
     * projects.
     * </pre>
     */
    public void listNoteOccurrences(com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListNoteOccurrencesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public void getVulnzOccurrencesSummary(com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVulnzOccurrencesSummaryMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified `Note` or `Occurrence`.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a `Note` or an `Occurrence`, respectively.
     * Attempting to call this method without these permissions will result in a `
     * `PERMISSION_DENIED` error.
     * Attempting to call this method on a non-existent resource will result in a
     * `NOT_FOUND` error if the user has `containeranalysis.notes.list` permission
     * on a `Note` or `containeranalysis.occurrences.list` on an `Occurrence`, or
     * a `PERMISSION_DENIED` error otherwise. The resource takes the following
     * formats: `projects/{projectid}/occurrences/{occurrenceid}` for occurrences
     * and projects/{projectid}/notes/{noteid} for notes
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a note or an `Occurrence` resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * Attempting to call this method on a resource without the required
     * permission will result in a `PERMISSION_DENIED` error. Attempting to call
     * this method on a non-existent resource will result in a `NOT_FOUND` error
     * if the user has list permission on the project, or a `PERMISSION_DENIED`
     * error otherwise. The resource takes the following formats:
     * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for occurrences and
     * projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence resource. Requires list permission on the project (for example,
     * "storage.objects.list" on the containing bucket for testing permission of
     * an object). Attempting to call this method on a non-existent resource will
     * result in a `NOT_FOUND` error if the user has list permission on the
     * project, or a `PERMISSION_DENIED` error otherwise. The resource takes the
     * following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for
     * `Occurrences` and `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new `Operation`.
     * </pre>
     */
    public void createOperation(com.google.containeranalysis.v1alpha1.CreateOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateOperationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing operation returns an error if operation
     *  does not exist. The only valid operations are to update mark the done bit
     * change the result.
     * </pre>
     */
    public void updateOperation(com.google.containeranalysis.v1alpha1.UpdateOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOperationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a specific scan configuration for a project.
     * </pre>
     */
    public void getScanConfig(com.google.containeranalysis.v1alpha1.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ScanConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetScanConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Lists scan configurations for a project.
     * </pre>
     */
    public void listScanConfigs(com.google.containeranalysis.v1alpha1.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListScanConfigsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the scan configuration to a new value.
     * </pre>
     */
    public void updateScanConfig(com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ScanConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateScanConfigMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.GetOccurrenceRequest,
                com.google.containeranalysis.v1alpha1.Occurrence>(
                  this, METHODID_GET_OCCURRENCE)))
          .addMethod(
            getListOccurrencesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.ListOccurrencesRequest,
                com.google.containeranalysis.v1alpha1.ListOccurrencesResponse>(
                  this, METHODID_LIST_OCCURRENCES)))
          .addMethod(
            getDeleteOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_OCCURRENCE)))
          .addMethod(
            getCreateOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest,
                com.google.containeranalysis.v1alpha1.Occurrence>(
                  this, METHODID_CREATE_OCCURRENCE)))
          .addMethod(
            getUpdateOccurrenceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest,
                com.google.containeranalysis.v1alpha1.Occurrence>(
                  this, METHODID_UPDATE_OCCURRENCE)))
          .addMethod(
            getGetOccurrenceNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest,
                com.google.containeranalysis.v1alpha1.Note>(
                  this, METHODID_GET_OCCURRENCE_NOTE)))
          .addMethod(
            getGetNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.GetNoteRequest,
                com.google.containeranalysis.v1alpha1.Note>(
                  this, METHODID_GET_NOTE)))
          .addMethod(
            getListNotesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.ListNotesRequest,
                com.google.containeranalysis.v1alpha1.ListNotesResponse>(
                  this, METHODID_LIST_NOTES)))
          .addMethod(
            getDeleteNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.DeleteNoteRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_NOTE)))
          .addMethod(
            getCreateNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.CreateNoteRequest,
                com.google.containeranalysis.v1alpha1.Note>(
                  this, METHODID_CREATE_NOTE)))
          .addMethod(
            getUpdateNoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.UpdateNoteRequest,
                com.google.containeranalysis.v1alpha1.Note>(
                  this, METHODID_UPDATE_NOTE)))
          .addMethod(
            getListNoteOccurrencesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest,
                com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse>(
                  this, METHODID_LIST_NOTE_OCCURRENCES)))
          .addMethod(
            getGetVulnzOccurrencesSummaryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest,
                com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse>(
                  this, METHODID_GET_VULNZ_OCCURRENCES_SUMMARY)))
          .addMethod(
            getSetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getGetIamPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
            getCreateOperationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.CreateOperationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_OPERATION)))
          .addMethod(
            getUpdateOperationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.UpdateOperationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_OPERATION)))
          .addMethod(
            getGetScanConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.GetScanConfigRequest,
                com.google.containeranalysis.v1alpha1.ScanConfig>(
                  this, METHODID_GET_SCAN_CONFIG)))
          .addMethod(
            getListScanConfigsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.ListScanConfigsRequest,
                com.google.containeranalysis.v1alpha1.ListScanConfigsResponse>(
                  this, METHODID_LIST_SCAN_CONFIGS)))
          .addMethod(
            getUpdateScanConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest,
                com.google.containeranalysis.v1alpha1.ScanConfig>(
                  this, METHODID_UPDATE_SCAN_CONFIG)))
          .build();
    }
  }

  /**
   * <pre>
   * Retrieves the results of vulnerability scanning of cloud components such as
   * container images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
   * The vulnerability results are stored as a series of Occurrences.
   * An `Occurrence` contains information about a specific vulnerability in a
   * resource. An `Occurrence` references a `Note`. A `Note` contains details
   * about the vulnerability and is stored in a stored in a separate project.
   * Multiple `Occurrences` can reference the same `Note`. For example, an SSL
   * vulnerability could affect multiple packages in an image. In this case,
   * there would be one `Note` for the vulnerability and an `Occurrence` for
   * each package with the vulnerability referencing that `Note`.
   * </pre>
   */
  public static final class ContainerAnalysisStub extends io.grpc.stub.AbstractStub<ContainerAnalysisStub> {
    private ContainerAnalysisStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContainerAnalysisStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the requested `Occurrence`.
     * </pre>
     */
    public void getOccurrence(com.google.containeranalysis.v1alpha1.GetOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists active `Occurrences` for a given project matching the filters.
     * </pre>
     */
    public void listOccurrences(com.google.containeranalysis.v1alpha1.ListOccurrencesRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOccurrencesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the given `Occurrence` from the system. Use this when
     * an `Occurrence` is no longer applicable for the given resource.
     * </pre>
     */
    public void deleteOccurrence(com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new `Occurrence`. Use this method to create `Occurrences`
     * for a resource.
     * </pre>
     */
    public void createOccurrence(com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing occurrence.
     * </pre>
     */
    public void updateOccurrence(com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the `Note` attached to the given `Occurrence`.
     * </pre>
     */
    public void getOccurrenceNote(com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the requested `Note`.
     * </pre>
     */
    public void getNote(com.google.containeranalysis.v1alpha1.GetNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all `Notes` for a given project.
     * </pre>
     */
    public void listNotes(com.google.containeranalysis.v1alpha1.ListNotesRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListNotesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNotesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the given `Note` from the system.
     * </pre>
     */
    public void deleteNote(com.google.containeranalysis.v1alpha1.DeleteNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new `Note`.
     * </pre>
     */
    public void createNote(com.google.containeranalysis.v1alpha1.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing `Note`.
     * </pre>
     */
    public void updateNote(com.google.containeranalysis.v1alpha1.UpdateNoteRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateNoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists `Occurrences` referencing the specified `Note`. Use this method to
     * get all occurrences referencing your `Note` across all your customer
     * projects.
     * </pre>
     */
    public void listNoteOccurrences(com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public void getVulnzOccurrencesSummary(com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVulnzOccurrencesSummaryMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified `Note` or `Occurrence`.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a `Note` or an `Occurrence`, respectively.
     * Attempting to call this method without these permissions will result in a `
     * `PERMISSION_DENIED` error.
     * Attempting to call this method on a non-existent resource will result in a
     * `NOT_FOUND` error if the user has `containeranalysis.notes.list` permission
     * on a `Note` or `containeranalysis.occurrences.list` on an `Occurrence`, or
     * a `PERMISSION_DENIED` error otherwise. The resource takes the following
     * formats: `projects/{projectid}/occurrences/{occurrenceid}` for occurrences
     * and projects/{projectid}/notes/{noteid} for notes
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a note or an `Occurrence` resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * Attempting to call this method on a resource without the required
     * permission will result in a `PERMISSION_DENIED` error. Attempting to call
     * this method on a non-existent resource will result in a `NOT_FOUND` error
     * if the user has list permission on the project, or a `PERMISSION_DENIED`
     * error otherwise. The resource takes the following formats:
     * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for occurrences and
     * projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence resource. Requires list permission on the project (for example,
     * "storage.objects.list" on the containing bucket for testing permission of
     * an object). Attempting to call this method on a non-existent resource will
     * result in a `NOT_FOUND` error if the user has list permission on the
     * project, or a `PERMISSION_DENIED` error otherwise. The resource takes the
     * following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for
     * `Occurrences` and `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new `Operation`.
     * </pre>
     */
    public void createOperation(com.google.containeranalysis.v1alpha1.CreateOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateOperationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing operation returns an error if operation
     *  does not exist. The only valid operations are to update mark the done bit
     * change the result.
     * </pre>
     */
    public void updateOperation(com.google.containeranalysis.v1alpha1.UpdateOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOperationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a specific scan configuration for a project.
     * </pre>
     */
    public void getScanConfig(com.google.containeranalysis.v1alpha1.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ScanConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScanConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists scan configurations for a project.
     * </pre>
     */
    public void listScanConfigs(com.google.containeranalysis.v1alpha1.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListScanConfigsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the scan configuration to a new value.
     * </pre>
     */
    public void updateScanConfig(com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ScanConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Retrieves the results of vulnerability scanning of cloud components such as
   * container images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
   * The vulnerability results are stored as a series of Occurrences.
   * An `Occurrence` contains information about a specific vulnerability in a
   * resource. An `Occurrence` references a `Note`. A `Note` contains details
   * about the vulnerability and is stored in a stored in a separate project.
   * Multiple `Occurrences` can reference the same `Note`. For example, an SSL
   * vulnerability could affect multiple packages in an image. In this case,
   * there would be one `Note` for the vulnerability and an `Occurrence` for
   * each package with the vulnerability referencing that `Note`.
   * </pre>
   */
  public static final class ContainerAnalysisBlockingStub extends io.grpc.stub.AbstractStub<ContainerAnalysisBlockingStub> {
    private ContainerAnalysisBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContainerAnalysisBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the requested `Occurrence`.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Occurrence getOccurrence(com.google.containeranalysis.v1alpha1.GetOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists active `Occurrences` for a given project matching the filters.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.ListOccurrencesResponse listOccurrences(com.google.containeranalysis.v1alpha1.ListOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListOccurrencesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the given `Occurrence` from the system. Use this when
     * an `Occurrence` is no longer applicable for the given resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteOccurrence(com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new `Occurrence`. Use this method to create `Occurrences`
     * for a resource.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Occurrence createOccurrence(com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing occurrence.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Occurrence updateOccurrence(com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOccurrenceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the `Note` attached to the given `Occurrence`.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Note getOccurrenceNote(com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOccurrenceNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the requested `Note`.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Note getNote(com.google.containeranalysis.v1alpha1.GetNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all `Notes` for a given project.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.ListNotesResponse listNotes(com.google.containeranalysis.v1alpha1.ListNotesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNotesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the given `Note` from the system.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNote(com.google.containeranalysis.v1alpha1.DeleteNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new `Note`.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Note createNote(com.google.containeranalysis.v1alpha1.CreateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing `Note`.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.Note updateNote(com.google.containeranalysis.v1alpha1.UpdateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateNoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists `Occurrences` referencing the specified `Note`. Use this method to
     * get all occurrences referencing your `Note` across all your customer
     * projects.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse listNoteOccurrences(com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListNoteOccurrencesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse getVulnzOccurrencesSummary(com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetVulnzOccurrencesSummaryMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified `Note` or `Occurrence`.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a `Note` or an `Occurrence`, respectively.
     * Attempting to call this method without these permissions will result in a `
     * `PERMISSION_DENIED` error.
     * Attempting to call this method on a non-existent resource will result in a
     * `NOT_FOUND` error if the user has `containeranalysis.notes.list` permission
     * on a `Note` or `containeranalysis.occurrences.list` on an `Occurrence`, or
     * a `PERMISSION_DENIED` error otherwise. The resource takes the following
     * formats: `projects/{projectid}/occurrences/{occurrenceid}` for occurrences
     * and projects/{projectid}/notes/{noteid} for notes
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a note or an `Occurrence` resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * Attempting to call this method on a resource without the required
     * permission will result in a `PERMISSION_DENIED` error. Attempting to call
     * this method on a non-existent resource will result in a `NOT_FOUND` error
     * if the user has list permission on the project, or a `PERMISSION_DENIED`
     * error otherwise. The resource takes the following formats:
     * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for occurrences and
     * projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence resource. Requires list permission on the project (for example,
     * "storage.objects.list" on the containing bucket for testing permission of
     * an object). Attempting to call this method on a non-existent resource will
     * result in a `NOT_FOUND` error if the user has list permission on the
     * project, or a `PERMISSION_DENIED` error otherwise. The resource takes the
     * following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for
     * `Occurrences` and `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new `Operation`.
     * </pre>
     */
    public com.google.longrunning.Operation createOperation(com.google.containeranalysis.v1alpha1.CreateOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateOperationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing operation returns an error if operation
     *  does not exist. The only valid operations are to update mark the done bit
     * change the result.
     * </pre>
     */
    public com.google.longrunning.Operation updateOperation(com.google.containeranalysis.v1alpha1.UpdateOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOperationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a specific scan configuration for a project.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.ScanConfig getScanConfig(com.google.containeranalysis.v1alpha1.GetScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetScanConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists scan configurations for a project.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.ListScanConfigsResponse listScanConfigs(com.google.containeranalysis.v1alpha1.ListScanConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListScanConfigsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the scan configuration to a new value.
     * </pre>
     */
    public com.google.containeranalysis.v1alpha1.ScanConfig updateScanConfig(com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateScanConfigMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Retrieves the results of vulnerability scanning of cloud components such as
   * container images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
   * The vulnerability results are stored as a series of Occurrences.
   * An `Occurrence` contains information about a specific vulnerability in a
   * resource. An `Occurrence` references a `Note`. A `Note` contains details
   * about the vulnerability and is stored in a stored in a separate project.
   * Multiple `Occurrences` can reference the same `Note`. For example, an SSL
   * vulnerability could affect multiple packages in an image. In this case,
   * there would be one `Note` for the vulnerability and an `Occurrence` for
   * each package with the vulnerability referencing that `Note`.
   * </pre>
   */
  public static final class ContainerAnalysisFutureStub extends io.grpc.stub.AbstractStub<ContainerAnalysisFutureStub> {
    private ContainerAnalysisFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ContainerAnalysisFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the requested `Occurrence`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Occurrence> getOccurrence(
        com.google.containeranalysis.v1alpha1.GetOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists active `Occurrences` for a given project matching the filters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.ListOccurrencesResponse> listOccurrences(
        com.google.containeranalysis.v1alpha1.ListOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOccurrencesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the given `Occurrence` from the system. Use this when
     * an `Occurrence` is no longer applicable for the given resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteOccurrence(
        com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new `Occurrence`. Use this method to create `Occurrences`
     * for a resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Occurrence> createOccurrence(
        com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing occurrence.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Occurrence> updateOccurrence(
        com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOccurrenceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the `Note` attached to the given `Occurrence`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Note> getOccurrenceNote(
        com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOccurrenceNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the requested `Note`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Note> getNote(
        com.google.containeranalysis.v1alpha1.GetNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all `Notes` for a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.ListNotesResponse> listNotes(
        com.google.containeranalysis.v1alpha1.ListNotesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNotesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the given `Note` from the system.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNote(
        com.google.containeranalysis.v1alpha1.DeleteNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new `Note`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Note> createNote(
        com.google.containeranalysis.v1alpha1.CreateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing `Note`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.Note> updateNote(
        com.google.containeranalysis.v1alpha1.UpdateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateNoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists `Occurrences` referencing the specified `Note`. Use this method to
     * get all occurrences referencing your `Note` across all your customer
     * projects.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse> listNoteOccurrences(
        com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListNoteOccurrencesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse> getVulnzOccurrencesSummary(
        com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVulnzOccurrencesSummaryMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified `Note` or `Occurrence`.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a `Note` or an `Occurrence`, respectively.
     * Attempting to call this method without these permissions will result in a `
     * `PERMISSION_DENIED` error.
     * Attempting to call this method on a non-existent resource will result in a
     * `NOT_FOUND` error if the user has `containeranalysis.notes.list` permission
     * on a `Note` or `containeranalysis.occurrences.list` on an `Occurrence`, or
     * a `PERMISSION_DENIED` error otherwise. The resource takes the following
     * formats: `projects/{projectid}/occurrences/{occurrenceid}` for occurrences
     * and projects/{projectid}/notes/{noteid} for notes
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a note or an `Occurrence` resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * Attempting to call this method on a resource without the required
     * permission will result in a `PERMISSION_DENIED` error. Attempting to call
     * this method on a non-existent resource will result in a `NOT_FOUND` error
     * if the user has list permission on the project, or a `PERMISSION_DENIED`
     * error otherwise. The resource takes the following formats:
     * `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for occurrences and
     * projects/{PROJECT_ID}/notes/{NOTE_ID} for notes
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence resource. Requires list permission on the project (for example,
     * "storage.objects.list" on the containing bucket for testing permission of
     * an object). Attempting to call this method on a non-existent resource will
     * result in a `NOT_FOUND` error if the user has list permission on the
     * project, or a `PERMISSION_DENIED` error otherwise. The resource takes the
     * following formats: `projects/{PROJECT_ID}/occurrences/{OCCURRENCE_ID}` for
     * `Occurrences` and `projects/{PROJECT_ID}/notes/{NOTE_ID}` for `Notes`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new `Operation`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createOperation(
        com.google.containeranalysis.v1alpha1.CreateOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateOperationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing operation returns an error if operation
     *  does not exist. The only valid operations are to update mark the done bit
     * change the result.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateOperation(
        com.google.containeranalysis.v1alpha1.UpdateOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOperationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a specific scan configuration for a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.ScanConfig> getScanConfig(
        com.google.containeranalysis.v1alpha1.GetScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScanConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists scan configurations for a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.ListScanConfigsResponse> listScanConfigs(
        com.google.containeranalysis.v1alpha1.ListScanConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListScanConfigsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the scan configuration to a new value.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.containeranalysis.v1alpha1.ScanConfig> updateScanConfig(
        com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OCCURRENCE = 0;
  private static final int METHODID_LIST_OCCURRENCES = 1;
  private static final int METHODID_DELETE_OCCURRENCE = 2;
  private static final int METHODID_CREATE_OCCURRENCE = 3;
  private static final int METHODID_UPDATE_OCCURRENCE = 4;
  private static final int METHODID_GET_OCCURRENCE_NOTE = 5;
  private static final int METHODID_GET_NOTE = 6;
  private static final int METHODID_LIST_NOTES = 7;
  private static final int METHODID_DELETE_NOTE = 8;
  private static final int METHODID_CREATE_NOTE = 9;
  private static final int METHODID_UPDATE_NOTE = 10;
  private static final int METHODID_LIST_NOTE_OCCURRENCES = 11;
  private static final int METHODID_GET_VULNZ_OCCURRENCES_SUMMARY = 12;
  private static final int METHODID_SET_IAM_POLICY = 13;
  private static final int METHODID_GET_IAM_POLICY = 14;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 15;
  private static final int METHODID_CREATE_OPERATION = 16;
  private static final int METHODID_UPDATE_OPERATION = 17;
  private static final int METHODID_GET_SCAN_CONFIG = 18;
  private static final int METHODID_LIST_SCAN_CONFIGS = 19;
  private static final int METHODID_UPDATE_SCAN_CONFIG = 20;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContainerAnalysisImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContainerAnalysisImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_OCCURRENCE:
          serviceImpl.getOccurrence((com.google.containeranalysis.v1alpha1.GetOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence>) responseObserver);
          break;
        case METHODID_LIST_OCCURRENCES:
          serviceImpl.listOccurrences((com.google.containeranalysis.v1alpha1.ListOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListOccurrencesResponse>) responseObserver);
          break;
        case METHODID_DELETE_OCCURRENCE:
          serviceImpl.deleteOccurrence((com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_OCCURRENCE:
          serviceImpl.createOccurrence((com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence>) responseObserver);
          break;
        case METHODID_UPDATE_OCCURRENCE:
          serviceImpl.updateOccurrence((com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Occurrence>) responseObserver);
          break;
        case METHODID_GET_OCCURRENCE_NOTE:
          serviceImpl.getOccurrenceNote((com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note>) responseObserver);
          break;
        case METHODID_GET_NOTE:
          serviceImpl.getNote((com.google.containeranalysis.v1alpha1.GetNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTES:
          serviceImpl.listNotes((com.google.containeranalysis.v1alpha1.ListNotesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListNotesResponse>) responseObserver);
          break;
        case METHODID_DELETE_NOTE:
          serviceImpl.deleteNote((com.google.containeranalysis.v1alpha1.DeleteNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_NOTE:
          serviceImpl.createNote((com.google.containeranalysis.v1alpha1.CreateNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note>) responseObserver);
          break;
        case METHODID_UPDATE_NOTE:
          serviceImpl.updateNote((com.google.containeranalysis.v1alpha1.UpdateNoteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.Note>) responseObserver);
          break;
        case METHODID_LIST_NOTE_OCCURRENCES:
          serviceImpl.listNoteOccurrences((com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse>) responseObserver);
          break;
        case METHODID_GET_VULNZ_OCCURRENCES_SUMMARY:
          serviceImpl.getVulnzOccurrencesSummary((com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
          break;
        case METHODID_CREATE_OPERATION:
          serviceImpl.createOperation((com.google.containeranalysis.v1alpha1.CreateOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_OPERATION:
          serviceImpl.updateOperation((com.google.containeranalysis.v1alpha1.UpdateOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SCAN_CONFIG:
          serviceImpl.getScanConfig((com.google.containeranalysis.v1alpha1.GetScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ScanConfig>) responseObserver);
          break;
        case METHODID_LIST_SCAN_CONFIGS:
          serviceImpl.listScanConfigs((com.google.containeranalysis.v1alpha1.ListScanConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ListScanConfigsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_SCAN_CONFIG:
          serviceImpl.updateScanConfig((com.google.containeranalysis.v1alpha1.UpdateScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1alpha1.ScanConfig>) responseObserver);
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

  private static abstract class ContainerAnalysisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContainerAnalysisBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.containeranalysis.v1alpha1.Containeranalysis.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContainerAnalysis");
    }
  }

  private static final class ContainerAnalysisFileDescriptorSupplier
      extends ContainerAnalysisBaseDescriptorSupplier {
    ContainerAnalysisFileDescriptorSupplier() {}
  }

  private static final class ContainerAnalysisMethodDescriptorSupplier
      extends ContainerAnalysisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContainerAnalysisMethodDescriptorSupplier(String methodName) {
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
      synchronized (ContainerAnalysisGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContainerAnalysisFileDescriptorSupplier())
              .addMethod(getGetOccurrenceMethodHelper())
              .addMethod(getListOccurrencesMethodHelper())
              .addMethod(getDeleteOccurrenceMethodHelper())
              .addMethod(getCreateOccurrenceMethodHelper())
              .addMethod(getUpdateOccurrenceMethodHelper())
              .addMethod(getGetOccurrenceNoteMethodHelper())
              .addMethod(getGetNoteMethodHelper())
              .addMethod(getListNotesMethodHelper())
              .addMethod(getDeleteNoteMethodHelper())
              .addMethod(getCreateNoteMethodHelper())
              .addMethod(getUpdateNoteMethodHelper())
              .addMethod(getListNoteOccurrencesMethodHelper())
              .addMethod(getGetVulnzOccurrencesSummaryMethodHelper())
              .addMethod(getSetIamPolicyMethodHelper())
              .addMethod(getGetIamPolicyMethodHelper())
              .addMethod(getTestIamPermissionsMethodHelper())
              .addMethod(getCreateOperationMethodHelper())
              .addMethod(getUpdateOperationMethodHelper())
              .addMethod(getGetScanConfigMethodHelper())
              .addMethod(getListScanConfigsMethodHelper())
              .addMethod(getUpdateScanConfigMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
