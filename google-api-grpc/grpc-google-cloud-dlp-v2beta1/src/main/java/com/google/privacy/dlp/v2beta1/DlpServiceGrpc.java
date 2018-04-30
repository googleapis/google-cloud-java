package com.google.privacy.dlp.v2beta1;

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
 * The DLP API is a service that allows clients
 * to detect the presence of Personally Identifiable Information (PII) and other
 * privacy-sensitive data in user-supplied, unstructured data streams, like text
 * blocks or images.
 * The service also includes methods for sensitive data redaction and
 * scheduling of data scans on Google Cloud Platform based data sets.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/privacy/dlp/v2beta1/dlp.proto")
public final class DlpServiceGrpc {

  private DlpServiceGrpc() {}

  public static final String SERVICE_NAME = "google.privacy.dlp.v2beta1.DlpService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInspectContentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.InspectContentRequest,
      com.google.privacy.dlp.v2beta1.InspectContentResponse> METHOD_INSPECT_CONTENT = getInspectContentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.InspectContentRequest,
      com.google.privacy.dlp.v2beta1.InspectContentResponse> getInspectContentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.InspectContentRequest,
      com.google.privacy.dlp.v2beta1.InspectContentResponse> getInspectContentMethod() {
    return getInspectContentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.InspectContentRequest,
      com.google.privacy.dlp.v2beta1.InspectContentResponse> getInspectContentMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.InspectContentRequest, com.google.privacy.dlp.v2beta1.InspectContentResponse> getInspectContentMethod;
    if ((getInspectContentMethod = DlpServiceGrpc.getInspectContentMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getInspectContentMethod = DlpServiceGrpc.getInspectContentMethod) == null) {
          DlpServiceGrpc.getInspectContentMethod = getInspectContentMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.InspectContentRequest, com.google.privacy.dlp.v2beta1.InspectContentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "InspectContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.InspectContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.InspectContentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("InspectContent"))
                  .build();
          }
        }
     }
     return getInspectContentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRedactContentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.RedactContentRequest,
      com.google.privacy.dlp.v2beta1.RedactContentResponse> METHOD_REDACT_CONTENT = getRedactContentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.RedactContentRequest,
      com.google.privacy.dlp.v2beta1.RedactContentResponse> getRedactContentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.RedactContentRequest,
      com.google.privacy.dlp.v2beta1.RedactContentResponse> getRedactContentMethod() {
    return getRedactContentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.RedactContentRequest,
      com.google.privacy.dlp.v2beta1.RedactContentResponse> getRedactContentMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.RedactContentRequest, com.google.privacy.dlp.v2beta1.RedactContentResponse> getRedactContentMethod;
    if ((getRedactContentMethod = DlpServiceGrpc.getRedactContentMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getRedactContentMethod = DlpServiceGrpc.getRedactContentMethod) == null) {
          DlpServiceGrpc.getRedactContentMethod = getRedactContentMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.RedactContentRequest, com.google.privacy.dlp.v2beta1.RedactContentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "RedactContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.RedactContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.RedactContentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("RedactContent"))
                  .build();
          }
        }
     }
     return getRedactContentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeidentifyContentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.DeidentifyContentRequest,
      com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> METHOD_DEIDENTIFY_CONTENT = getDeidentifyContentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.DeidentifyContentRequest,
      com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> getDeidentifyContentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.DeidentifyContentRequest,
      com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> getDeidentifyContentMethod() {
    return getDeidentifyContentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.DeidentifyContentRequest,
      com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> getDeidentifyContentMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.DeidentifyContentRequest, com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> getDeidentifyContentMethod;
    if ((getDeidentifyContentMethod = DlpServiceGrpc.getDeidentifyContentMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeidentifyContentMethod = DlpServiceGrpc.getDeidentifyContentMethod) == null) {
          DlpServiceGrpc.getDeidentifyContentMethod = getDeidentifyContentMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.DeidentifyContentRequest, com.google.privacy.dlp.v2beta1.DeidentifyContentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "DeidentifyContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.DeidentifyContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.DeidentifyContentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("DeidentifyContent"))
                  .build();
          }
        }
     }
     return getDeidentifyContentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInspectOperationMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest,
      com.google.longrunning.Operation> METHOD_CREATE_INSPECT_OPERATION = getCreateInspectOperationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest,
      com.google.longrunning.Operation> getCreateInspectOperationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest,
      com.google.longrunning.Operation> getCreateInspectOperationMethod() {
    return getCreateInspectOperationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest,
      com.google.longrunning.Operation> getCreateInspectOperationMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest, com.google.longrunning.Operation> getCreateInspectOperationMethod;
    if ((getCreateInspectOperationMethod = DlpServiceGrpc.getCreateInspectOperationMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateInspectOperationMethod = DlpServiceGrpc.getCreateInspectOperationMethod) == null) {
          DlpServiceGrpc.getCreateInspectOperationMethod = getCreateInspectOperationMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "CreateInspectOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("CreateInspectOperation"))
                  .build();
          }
        }
     }
     return getCreateInspectOperationMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnalyzeDataSourceRiskMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest,
      com.google.longrunning.Operation> METHOD_ANALYZE_DATA_SOURCE_RISK = getAnalyzeDataSourceRiskMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest,
      com.google.longrunning.Operation> getAnalyzeDataSourceRiskMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest,
      com.google.longrunning.Operation> getAnalyzeDataSourceRiskMethod() {
    return getAnalyzeDataSourceRiskMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest,
      com.google.longrunning.Operation> getAnalyzeDataSourceRiskMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest, com.google.longrunning.Operation> getAnalyzeDataSourceRiskMethod;
    if ((getAnalyzeDataSourceRiskMethod = DlpServiceGrpc.getAnalyzeDataSourceRiskMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getAnalyzeDataSourceRiskMethod = DlpServiceGrpc.getAnalyzeDataSourceRiskMethod) == null) {
          DlpServiceGrpc.getAnalyzeDataSourceRiskMethod = getAnalyzeDataSourceRiskMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "AnalyzeDataSourceRisk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("AnalyzeDataSourceRisk"))
                  .build();
          }
        }
     }
     return getAnalyzeDataSourceRiskMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInspectFindingsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest,
      com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> METHOD_LIST_INSPECT_FINDINGS = getListInspectFindingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest,
      com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> getListInspectFindingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest,
      com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> getListInspectFindingsMethod() {
    return getListInspectFindingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest,
      com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> getListInspectFindingsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest, com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> getListInspectFindingsMethod;
    if ((getListInspectFindingsMethod = DlpServiceGrpc.getListInspectFindingsMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListInspectFindingsMethod = DlpServiceGrpc.getListInspectFindingsMethod) == null) {
          DlpServiceGrpc.getListInspectFindingsMethod = getListInspectFindingsMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest, com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "ListInspectFindings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("ListInspectFindings"))
                  .build();
          }
        }
     }
     return getListInspectFindingsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInfoTypesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInfoTypesRequest,
      com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> METHOD_LIST_INFO_TYPES = getListInfoTypesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInfoTypesRequest,
      com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> getListInfoTypesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInfoTypesRequest,
      com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> getListInfoTypesMethod() {
    return getListInfoTypesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInfoTypesRequest,
      com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> getListInfoTypesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListInfoTypesRequest, com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> getListInfoTypesMethod;
    if ((getListInfoTypesMethod = DlpServiceGrpc.getListInfoTypesMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListInfoTypesMethod = DlpServiceGrpc.getListInfoTypesMethod) == null) {
          DlpServiceGrpc.getListInfoTypesMethod = getListInfoTypesMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.ListInfoTypesRequest, com.google.privacy.dlp.v2beta1.ListInfoTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "ListInfoTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.ListInfoTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.ListInfoTypesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("ListInfoTypes"))
                  .build();
          }
        }
     }
     return getListInfoTypesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListRootCategoriesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest,
      com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> METHOD_LIST_ROOT_CATEGORIES = getListRootCategoriesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest,
      com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> getListRootCategoriesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest,
      com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> getListRootCategoriesMethod() {
    return getListRootCategoriesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest,
      com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> getListRootCategoriesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest, com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> getListRootCategoriesMethod;
    if ((getListRootCategoriesMethod = DlpServiceGrpc.getListRootCategoriesMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListRootCategoriesMethod = DlpServiceGrpc.getListRootCategoriesMethod) == null) {
          DlpServiceGrpc.getListRootCategoriesMethod = getListRootCategoriesMethod = 
              io.grpc.MethodDescriptor.<com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest, com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.privacy.dlp.v2beta1.DlpService", "ListRootCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("ListRootCategories"))
                  .build();
          }
        }
     }
     return getListRootCategoriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DlpServiceStub newStub(io.grpc.Channel channel) {
    return new DlpServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DlpServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DlpServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DlpServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DlpServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The DLP API is a service that allows clients
   * to detect the presence of Personally Identifiable Information (PII) and other
   * privacy-sensitive data in user-supplied, unstructured data streams, like text
   * blocks or images.
   * The service also includes methods for sensitive data redaction and
   * scheduling of data scans on Google Cloud Platform based data sets.
   * </pre>
   */
  public static abstract class DlpServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Finds potentially sensitive info in a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public void inspectContent(com.google.privacy.dlp.v2beta1.InspectContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.InspectContentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInspectContentMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Redacts potentially sensitive info from a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public void redactContent(com.google.privacy.dlp.v2beta1.RedactContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.RedactContentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRedactContentMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * De-identifies potentially sensitive info from a list of strings.
     * This method has limits on input size and output size.
     * </pre>
     */
    public void deidentifyContent(com.google.privacy.dlp.v2beta1.DeidentifyContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeidentifyContentMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Schedules a job scanning content in a Google Cloud Platform data
     * repository.
     * </pre>
     */
    public void createInspectOperation(com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInspectOperationMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Schedules a job to compute risk analysis metrics over content in a Google
     * Cloud Platform repository.
     * </pre>
     */
    public void analyzeDataSourceRisk(com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyzeDataSourceRiskMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns list of results for given inspect operation result set id.
     * </pre>
     */
    public void listInspectFindings(com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInspectFindingsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns sensitive information types for given category.
     * </pre>
     */
    public void listInfoTypes(com.google.privacy.dlp.v2beta1.ListInfoTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInfoTypesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns the list of root categories of sensitive information.
     * </pre>
     */
    public void listRootCategories(com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListRootCategoriesMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInspectContentMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.InspectContentRequest,
                com.google.privacy.dlp.v2beta1.InspectContentResponse>(
                  this, METHODID_INSPECT_CONTENT)))
          .addMethod(
            getRedactContentMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.RedactContentRequest,
                com.google.privacy.dlp.v2beta1.RedactContentResponse>(
                  this, METHODID_REDACT_CONTENT)))
          .addMethod(
            getDeidentifyContentMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.DeidentifyContentRequest,
                com.google.privacy.dlp.v2beta1.DeidentifyContentResponse>(
                  this, METHODID_DEIDENTIFY_CONTENT)))
          .addMethod(
            getCreateInspectOperationMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_INSPECT_OPERATION)))
          .addMethod(
            getAnalyzeDataSourceRiskMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_ANALYZE_DATA_SOURCE_RISK)))
          .addMethod(
            getListInspectFindingsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest,
                com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse>(
                  this, METHODID_LIST_INSPECT_FINDINGS)))
          .addMethod(
            getListInfoTypesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.ListInfoTypesRequest,
                com.google.privacy.dlp.v2beta1.ListInfoTypesResponse>(
                  this, METHODID_LIST_INFO_TYPES)))
          .addMethod(
            getListRootCategoriesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest,
                com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse>(
                  this, METHODID_LIST_ROOT_CATEGORIES)))
          .build();
    }
  }

  /**
   * <pre>
   * The DLP API is a service that allows clients
   * to detect the presence of Personally Identifiable Information (PII) and other
   * privacy-sensitive data in user-supplied, unstructured data streams, like text
   * blocks or images.
   * The service also includes methods for sensitive data redaction and
   * scheduling of data scans on Google Cloud Platform based data sets.
   * </pre>
   */
  public static final class DlpServiceStub extends io.grpc.stub.AbstractStub<DlpServiceStub> {
    private DlpServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DlpServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DlpServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DlpServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Finds potentially sensitive info in a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public void inspectContent(com.google.privacy.dlp.v2beta1.InspectContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.InspectContentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInspectContentMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Redacts potentially sensitive info from a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public void redactContent(com.google.privacy.dlp.v2beta1.RedactContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.RedactContentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRedactContentMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * De-identifies potentially sensitive info from a list of strings.
     * This method has limits on input size and output size.
     * </pre>
     */
    public void deidentifyContent(com.google.privacy.dlp.v2beta1.DeidentifyContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeidentifyContentMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Schedules a job scanning content in a Google Cloud Platform data
     * repository.
     * </pre>
     */
    public void createInspectOperation(com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInspectOperationMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Schedules a job to compute risk analysis metrics over content in a Google
     * Cloud Platform repository.
     * </pre>
     */
    public void analyzeDataSourceRisk(com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyzeDataSourceRiskMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns list of results for given inspect operation result set id.
     * </pre>
     */
    public void listInspectFindings(com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInspectFindingsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns sensitive information types for given category.
     * </pre>
     */
    public void listInfoTypes(com.google.privacy.dlp.v2beta1.ListInfoTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInfoTypesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the list of root categories of sensitive information.
     * </pre>
     */
    public void listRootCategories(com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListRootCategoriesMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The DLP API is a service that allows clients
   * to detect the presence of Personally Identifiable Information (PII) and other
   * privacy-sensitive data in user-supplied, unstructured data streams, like text
   * blocks or images.
   * The service also includes methods for sensitive data redaction and
   * scheduling of data scans on Google Cloud Platform based data sets.
   * </pre>
   */
  public static final class DlpServiceBlockingStub extends io.grpc.stub.AbstractStub<DlpServiceBlockingStub> {
    private DlpServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DlpServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DlpServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DlpServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Finds potentially sensitive info in a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public com.google.privacy.dlp.v2beta1.InspectContentResponse inspectContent(com.google.privacy.dlp.v2beta1.InspectContentRequest request) {
      return blockingUnaryCall(
          getChannel(), getInspectContentMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Redacts potentially sensitive info from a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public com.google.privacy.dlp.v2beta1.RedactContentResponse redactContent(com.google.privacy.dlp.v2beta1.RedactContentRequest request) {
      return blockingUnaryCall(
          getChannel(), getRedactContentMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * De-identifies potentially sensitive info from a list of strings.
     * This method has limits on input size and output size.
     * </pre>
     */
    public com.google.privacy.dlp.v2beta1.DeidentifyContentResponse deidentifyContent(com.google.privacy.dlp.v2beta1.DeidentifyContentRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeidentifyContentMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Schedules a job scanning content in a Google Cloud Platform data
     * repository.
     * </pre>
     */
    public com.google.longrunning.Operation createInspectOperation(com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInspectOperationMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Schedules a job to compute risk analysis metrics over content in a Google
     * Cloud Platform repository.
     * </pre>
     */
    public com.google.longrunning.Operation analyzeDataSourceRisk(com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyzeDataSourceRiskMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns list of results for given inspect operation result set id.
     * </pre>
     */
    public com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse listInspectFindings(com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInspectFindingsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns sensitive information types for given category.
     * </pre>
     */
    public com.google.privacy.dlp.v2beta1.ListInfoTypesResponse listInfoTypes(com.google.privacy.dlp.v2beta1.ListInfoTypesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInfoTypesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the list of root categories of sensitive information.
     * </pre>
     */
    public com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse listRootCategories(com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListRootCategoriesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The DLP API is a service that allows clients
   * to detect the presence of Personally Identifiable Information (PII) and other
   * privacy-sensitive data in user-supplied, unstructured data streams, like text
   * blocks or images.
   * The service also includes methods for sensitive data redaction and
   * scheduling of data scans on Google Cloud Platform based data sets.
   * </pre>
   */
  public static final class DlpServiceFutureStub extends io.grpc.stub.AbstractStub<DlpServiceFutureStub> {
    private DlpServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DlpServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DlpServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DlpServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Finds potentially sensitive info in a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2beta1.InspectContentResponse> inspectContent(
        com.google.privacy.dlp.v2beta1.InspectContentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInspectContentMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Redacts potentially sensitive info from a list of strings.
     * This method has limits on input size, processing time, and output size.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2beta1.RedactContentResponse> redactContent(
        com.google.privacy.dlp.v2beta1.RedactContentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRedactContentMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * De-identifies potentially sensitive info from a list of strings.
     * This method has limits on input size and output size.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2beta1.DeidentifyContentResponse> deidentifyContent(
        com.google.privacy.dlp.v2beta1.DeidentifyContentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeidentifyContentMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Schedules a job scanning content in a Google Cloud Platform data
     * repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInspectOperation(
        com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInspectOperationMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Schedules a job to compute risk analysis metrics over content in a Google
     * Cloud Platform repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> analyzeDataSourceRisk(
        com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyzeDataSourceRiskMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns list of results for given inspect operation result set id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse> listInspectFindings(
        com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInspectFindingsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns sensitive information types for given category.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2beta1.ListInfoTypesResponse> listInfoTypes(
        com.google.privacy.dlp.v2beta1.ListInfoTypesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInfoTypesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the list of root categories of sensitive information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse> listRootCategories(
        com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListRootCategoriesMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSPECT_CONTENT = 0;
  private static final int METHODID_REDACT_CONTENT = 1;
  private static final int METHODID_DEIDENTIFY_CONTENT = 2;
  private static final int METHODID_CREATE_INSPECT_OPERATION = 3;
  private static final int METHODID_ANALYZE_DATA_SOURCE_RISK = 4;
  private static final int METHODID_LIST_INSPECT_FINDINGS = 5;
  private static final int METHODID_LIST_INFO_TYPES = 6;
  private static final int METHODID_LIST_ROOT_CATEGORIES = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DlpServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DlpServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSPECT_CONTENT:
          serviceImpl.inspectContent((com.google.privacy.dlp.v2beta1.InspectContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.InspectContentResponse>) responseObserver);
          break;
        case METHODID_REDACT_CONTENT:
          serviceImpl.redactContent((com.google.privacy.dlp.v2beta1.RedactContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.RedactContentResponse>) responseObserver);
          break;
        case METHODID_DEIDENTIFY_CONTENT:
          serviceImpl.deidentifyContent((com.google.privacy.dlp.v2beta1.DeidentifyContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.DeidentifyContentResponse>) responseObserver);
          break;
        case METHODID_CREATE_INSPECT_OPERATION:
          serviceImpl.createInspectOperation((com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ANALYZE_DATA_SOURCE_RISK:
          serviceImpl.analyzeDataSourceRisk((com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INSPECT_FINDINGS:
          serviceImpl.listInspectFindings((com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse>) responseObserver);
          break;
        case METHODID_LIST_INFO_TYPES:
          serviceImpl.listInfoTypes((com.google.privacy.dlp.v2beta1.ListInfoTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListInfoTypesResponse>) responseObserver);
          break;
        case METHODID_LIST_ROOT_CATEGORIES:
          serviceImpl.listRootCategories((com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse>) responseObserver);
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

  private static abstract class DlpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DlpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.privacy.dlp.v2beta1.DlpProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DlpService");
    }
  }

  private static final class DlpServiceFileDescriptorSupplier
      extends DlpServiceBaseDescriptorSupplier {
    DlpServiceFileDescriptorSupplier() {}
  }

  private static final class DlpServiceMethodDescriptorSupplier
      extends DlpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DlpServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DlpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DlpServiceFileDescriptorSupplier())
              .addMethod(getInspectContentMethodHelper())
              .addMethod(getRedactContentMethodHelper())
              .addMethod(getDeidentifyContentMethodHelper())
              .addMethod(getCreateInspectOperationMethodHelper())
              .addMethod(getAnalyzeDataSourceRiskMethodHelper())
              .addMethod(getListInspectFindingsMethodHelper())
              .addMethod(getListInfoTypesMethodHelper())
              .addMethod(getListRootCategoriesMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
