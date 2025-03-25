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
package com.google.containeranalysis.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Retrieves analysis results of Cloud components such as Docker container
 * images. The Container Analysis API is an implementation of the
 * [Grafeas](https://grafeas.io) API.
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
    comments = "Source: google/devtools/containeranalysis/v1/containeranalysis.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContainerAnalysisGrpc {

  private ContainerAnalysisGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.devtools.containeranalysis.v1.ContainerAnalysis";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = ContainerAnalysisGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getSetIamPolicyMethod = ContainerAnalysisGrpc.getSetIamPolicyMethod) == null) {
          ContainerAnalysisGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = ContainerAnalysisGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetIamPolicyMethod = ContainerAnalysisGrpc.getGetIamPolicyMethod) == null) {
          ContainerAnalysisGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = ContainerAnalysisGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getTestIamPermissionsMethod = ContainerAnalysisGrpc.getTestIamPermissionsMethod)
            == null) {
          ContainerAnalysisGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest,
          com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
      getGetVulnerabilityOccurrencesSummaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVulnerabilityOccurrencesSummary",
      requestType = com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest.class,
      responseType = com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest,
          com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
      getGetVulnerabilityOccurrencesSummaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest,
            com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
        getGetVulnerabilityOccurrencesSummaryMethod;
    if ((getGetVulnerabilityOccurrencesSummaryMethod =
            ContainerAnalysisGrpc.getGetVulnerabilityOccurrencesSummaryMethod)
        == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getGetVulnerabilityOccurrencesSummaryMethod =
                ContainerAnalysisGrpc.getGetVulnerabilityOccurrencesSummaryMethod)
            == null) {
          ContainerAnalysisGrpc.getGetVulnerabilityOccurrencesSummaryMethod =
              getGetVulnerabilityOccurrencesSummaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest,
                          com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetVulnerabilityOccurrencesSummary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1
                                  .GetVulnerabilityOccurrencesSummaryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisMethodDescriptorSupplier(
                              "GetVulnerabilityOccurrencesSummary"))
                      .build();
        }
      }
    }
    return getGetVulnerabilityOccurrencesSummaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1.ExportSBOMRequest,
          com.google.containeranalysis.v1.ExportSBOMResponse>
      getExportSBOMMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportSBOM",
      requestType = com.google.containeranalysis.v1.ExportSBOMRequest.class,
      responseType = com.google.containeranalysis.v1.ExportSBOMResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1.ExportSBOMRequest,
          com.google.containeranalysis.v1.ExportSBOMResponse>
      getExportSBOMMethod() {
    io.grpc.MethodDescriptor<
            com.google.containeranalysis.v1.ExportSBOMRequest,
            com.google.containeranalysis.v1.ExportSBOMResponse>
        getExportSBOMMethod;
    if ((getExportSBOMMethod = ContainerAnalysisGrpc.getExportSBOMMethod) == null) {
      synchronized (ContainerAnalysisGrpc.class) {
        if ((getExportSBOMMethod = ContainerAnalysisGrpc.getExportSBOMMethod) == null) {
          ContainerAnalysisGrpc.getExportSBOMMethod =
              getExportSBOMMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.containeranalysis.v1.ExportSBOMRequest,
                          com.google.containeranalysis.v1.ExportSBOMResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportSBOM"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1.ExportSBOMRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1.ExportSBOMResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisMethodDescriptorSupplier("ExportSBOM"))
                      .build();
        }
      }
    }
    return getExportSBOMMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContainerAnalysisStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisStub>() {
          @java.lang.Override
          public ContainerAnalysisStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContainerAnalysisStub(channel, callOptions);
          }
        };
    return ContainerAnalysisStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContainerAnalysisBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisBlockingStub>() {
          @java.lang.Override
          public ContainerAnalysisBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContainerAnalysisBlockingStub(channel, callOptions);
          }
        };
    return ContainerAnalysisBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContainerAnalysisFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisFutureStub>() {
          @java.lang.Override
          public ContainerAnalysisFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContainerAnalysisFutureStub(channel, callOptions);
          }
        };
    return ContainerAnalysisFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](https://grafeas.io) API.
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
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified note or occurrence.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or an occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a note or an occurrence resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence. Requires list permission on the project (for example,
     * `containeranalysis.notes.list`).
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    default void getVulnerabilityOccurrencesSummary(
        com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVulnerabilityOccurrencesSummaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an SBOM for the given resource.
     * </pre>
     */
    default void exportSBOM(
        com.google.containeranalysis.v1.ExportSBOMRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1.ExportSBOMResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportSBOMMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ContainerAnalysis.
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](https://grafeas.io) API.
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
  public abstract static class ContainerAnalysisImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ContainerAnalysisGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ContainerAnalysis.
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](https://grafeas.io) API.
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
  public static final class ContainerAnalysisStub
      extends io.grpc.stub.AbstractAsyncStub<ContainerAnalysisStub> {
    private ContainerAnalysisStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified note or occurrence.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or an occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a note or an occurrence resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence. Requires list permission on the project (for example,
     * `containeranalysis.notes.list`).
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
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
        com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVulnerabilityOccurrencesSummaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an SBOM for the given resource.
     * </pre>
     */
    public void exportSBOM(
        com.google.containeranalysis.v1.ExportSBOMRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1.ExportSBOMResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportSBOMMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ContainerAnalysis.
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](https://grafeas.io) API.
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
  public static final class ContainerAnalysisBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContainerAnalysisBlockingStub> {
    private ContainerAnalysisBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified note or occurrence.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or an occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a note or an occurrence resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence. Requires list permission on the project (for example,
     * `containeranalysis.notes.list`).
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary
        getVulnerabilityOccurrencesSummary(
            com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVulnerabilityOccurrencesSummaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates an SBOM for the given resource.
     * </pre>
     */
    public com.google.containeranalysis.v1.ExportSBOMResponse exportSBOM(
        com.google.containeranalysis.v1.ExportSBOMRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportSBOMMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ContainerAnalysis.
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](https://grafeas.io) API.
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
  public static final class ContainerAnalysisFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContainerAnalysisFutureStub> {
    private ContainerAnalysisFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified note or occurrence.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or an occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a note or an occurrence resource.
     * Requires `containeranalysis.notes.setIamPolicy` or
     * `containeranalysis.occurrences.setIamPolicy` permission if the resource is
     * a note or occurrence, respectively.
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified note or
     * occurrence. Requires list permission on the project (for example,
     * `containeranalysis.notes.list`).
     * The resource takes the format `projects/[PROJECT_ID]/notes/[NOTE_ID]` for
     * notes and `projects/[PROJECT_ID]/occurrences/[OCCURRENCE_ID]` for
     * occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a summary of the number and severity of occurrences.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>
        getVulnerabilityOccurrencesSummary(
            com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVulnerabilityOccurrencesSummaryMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generates an SBOM for the given resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.containeranalysis.v1.ExportSBOMResponse>
        exportSBOM(com.google.containeranalysis.v1.ExportSBOMRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportSBOMMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_IAM_POLICY = 0;
  private static final int METHODID_GET_IAM_POLICY = 1;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 2;
  private static final int METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY = 3;
  private static final int METHODID_EXPORT_SBOM = 4;

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
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY:
          serviceImpl.getVulnerabilityOccurrencesSummary(
              (com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>)
                  responseObserver);
          break;
        case METHODID_EXPORT_SBOM:
          serviceImpl.exportSBOM(
              (com.google.containeranalysis.v1.ExportSBOMRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1.ExportSBOMResponse>)
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
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getGetVulnerabilityOccurrencesSummaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest,
                    com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary>(
                    service, METHODID_GET_VULNERABILITY_OCCURRENCES_SUMMARY)))
        .addMethod(
            getExportSBOMMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.containeranalysis.v1.ExportSBOMRequest,
                    com.google.containeranalysis.v1.ExportSBOMResponse>(
                    service, METHODID_EXPORT_SBOM)))
        .build();
  }

  private abstract static class ContainerAnalysisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContainerAnalysisBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.containeranalysis.v1.Containeranalysis.getDescriptor();
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
    private final java.lang.String methodName;

    ContainerAnalysisMethodDescriptorSupplier(java.lang.String methodName) {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContainerAnalysisFileDescriptorSupplier())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getGetVulnerabilityOccurrencesSummaryMethod())
                      .addMethod(getExportSBOMMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
