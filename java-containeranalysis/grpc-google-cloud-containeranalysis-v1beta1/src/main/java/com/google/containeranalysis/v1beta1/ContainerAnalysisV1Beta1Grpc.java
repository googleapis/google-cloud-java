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
package com.google.containeranalysis.v1beta1;

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
 * Retrieves analysis results of Cloud components such as Docker container
 * images. The Container Analysis API is an implementation of the
 * [Grafeas](grafeas.io) API.
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
    comments = "Source: google/devtools/containeranalysis/v1beta1/containeranalysis.proto")
public final class ContainerAnalysisV1Beta1Grpc {

  private ContainerAnalysisV1Beta1Grpc() {}

  public static final String SERVICE_NAME =
      "google.devtools.containeranalysis.v1beta1.ContainerAnalysisV1Beta1";

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
    if ((getSetIamPolicyMethod = ContainerAnalysisV1Beta1Grpc.getSetIamPolicyMethod) == null) {
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        if ((getSetIamPolicyMethod = ContainerAnalysisV1Beta1Grpc.getSetIamPolicyMethod) == null) {
          ContainerAnalysisV1Beta1Grpc.getSetIamPolicyMethod =
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
                          new ContainerAnalysisV1Beta1MethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getGetIamPolicyMethod = ContainerAnalysisV1Beta1Grpc.getGetIamPolicyMethod) == null) {
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        if ((getGetIamPolicyMethod = ContainerAnalysisV1Beta1Grpc.getGetIamPolicyMethod) == null) {
          ContainerAnalysisV1Beta1Grpc.getGetIamPolicyMethod =
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
                          new ContainerAnalysisV1Beta1MethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = ContainerAnalysisV1Beta1Grpc.getTestIamPermissionsMethod)
        == null) {
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        if ((getTestIamPermissionsMethod = ContainerAnalysisV1Beta1Grpc.getTestIamPermissionsMethod)
            == null) {
          ContainerAnalysisV1Beta1Grpc.getTestIamPermissionsMethod =
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
                          new ContainerAnalysisV1Beta1MethodDescriptorSupplier(
                              "TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1beta1.GetScanConfigRequest,
          com.google.containeranalysis.v1beta1.ScanConfig>
      getGetScanConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetScanConfig",
      requestType = com.google.containeranalysis.v1beta1.GetScanConfigRequest.class,
      responseType = com.google.containeranalysis.v1beta1.ScanConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1beta1.GetScanConfigRequest,
          com.google.containeranalysis.v1beta1.ScanConfig>
      getGetScanConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.containeranalysis.v1beta1.GetScanConfigRequest,
            com.google.containeranalysis.v1beta1.ScanConfig>
        getGetScanConfigMethod;
    if ((getGetScanConfigMethod = ContainerAnalysisV1Beta1Grpc.getGetScanConfigMethod) == null) {
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        if ((getGetScanConfigMethod = ContainerAnalysisV1Beta1Grpc.getGetScanConfigMethod)
            == null) {
          ContainerAnalysisV1Beta1Grpc.getGetScanConfigMethod =
              getGetScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.containeranalysis.v1beta1.GetScanConfigRequest,
                          com.google.containeranalysis.v1beta1.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1beta1.GetScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1beta1.ScanConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisV1Beta1MethodDescriptorSupplier("GetScanConfig"))
                      .build();
        }
      }
    }
    return getGetScanConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1beta1.ListScanConfigsRequest,
          com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
      getListScanConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListScanConfigs",
      requestType = com.google.containeranalysis.v1beta1.ListScanConfigsRequest.class,
      responseType = com.google.containeranalysis.v1beta1.ListScanConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1beta1.ListScanConfigsRequest,
          com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
      getListScanConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.containeranalysis.v1beta1.ListScanConfigsRequest,
            com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
        getListScanConfigsMethod;
    if ((getListScanConfigsMethod = ContainerAnalysisV1Beta1Grpc.getListScanConfigsMethod)
        == null) {
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        if ((getListScanConfigsMethod = ContainerAnalysisV1Beta1Grpc.getListScanConfigsMethod)
            == null) {
          ContainerAnalysisV1Beta1Grpc.getListScanConfigsMethod =
              getListScanConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.containeranalysis.v1beta1.ListScanConfigsRequest,
                          com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListScanConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1beta1.ListScanConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1beta1.ListScanConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisV1Beta1MethodDescriptorSupplier("ListScanConfigs"))
                      .build();
        }
      }
    }
    return getListScanConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1beta1.UpdateScanConfigRequest,
          com.google.containeranalysis.v1beta1.ScanConfig>
      getUpdateScanConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateScanConfig",
      requestType = com.google.containeranalysis.v1beta1.UpdateScanConfigRequest.class,
      responseType = com.google.containeranalysis.v1beta1.ScanConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.containeranalysis.v1beta1.UpdateScanConfigRequest,
          com.google.containeranalysis.v1beta1.ScanConfig>
      getUpdateScanConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.containeranalysis.v1beta1.UpdateScanConfigRequest,
            com.google.containeranalysis.v1beta1.ScanConfig>
        getUpdateScanConfigMethod;
    if ((getUpdateScanConfigMethod = ContainerAnalysisV1Beta1Grpc.getUpdateScanConfigMethod)
        == null) {
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        if ((getUpdateScanConfigMethod = ContainerAnalysisV1Beta1Grpc.getUpdateScanConfigMethod)
            == null) {
          ContainerAnalysisV1Beta1Grpc.getUpdateScanConfigMethod =
              getUpdateScanConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.containeranalysis.v1beta1.UpdateScanConfigRequest,
                          com.google.containeranalysis.v1beta1.ScanConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateScanConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1beta1.UpdateScanConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.containeranalysis.v1beta1.ScanConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContainerAnalysisV1Beta1MethodDescriptorSupplier("UpdateScanConfig"))
                      .build();
        }
      }
    }
    return getUpdateScanConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContainerAnalysisV1Beta1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisV1Beta1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisV1Beta1Stub>() {
          @java.lang.Override
          public ContainerAnalysisV1Beta1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContainerAnalysisV1Beta1Stub(channel, callOptions);
          }
        };
    return ContainerAnalysisV1Beta1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContainerAnalysisV1Beta1BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisV1Beta1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisV1Beta1BlockingStub>() {
          @java.lang.Override
          public ContainerAnalysisV1Beta1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContainerAnalysisV1Beta1BlockingStub(channel, callOptions);
          }
        };
    return ContainerAnalysisV1Beta1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContainerAnalysisV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisV1Beta1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContainerAnalysisV1Beta1FutureStub>() {
          @java.lang.Override
          public ContainerAnalysisV1Beta1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContainerAnalysisV1Beta1FutureStub(channel, callOptions);
          }
        };
    return ContainerAnalysisV1Beta1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
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
  public abstract static class ContainerAnalysisV1Beta1ImplBase implements io.grpc.BindableService {

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
      asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified scan configuration.
     * </pre>
     */
    public void getScanConfig(
        com.google.containeranalysis.v1beta1.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ScanConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetScanConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists scan configurations for the specified project.
     * </pre>
     */
    public void listScanConfigs(
        com.google.containeranalysis.v1beta1.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListScanConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified scan configuration.
     * </pre>
     */
    public void updateScanConfig(
        com.google.containeranalysis.v1beta1.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ScanConfig>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateScanConfigMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getSetIamPolicyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getGetIamPolicyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
              getGetScanConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.containeranalysis.v1beta1.GetScanConfigRequest,
                      com.google.containeranalysis.v1beta1.ScanConfig>(
                      this, METHODID_GET_SCAN_CONFIG)))
          .addMethod(
              getListScanConfigsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.containeranalysis.v1beta1.ListScanConfigsRequest,
                      com.google.containeranalysis.v1beta1.ListScanConfigsResponse>(
                      this, METHODID_LIST_SCAN_CONFIGS)))
          .addMethod(
              getUpdateScanConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.containeranalysis.v1beta1.UpdateScanConfigRequest,
                      com.google.containeranalysis.v1beta1.ScanConfig>(
                      this, METHODID_UPDATE_SCAN_CONFIG)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
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
  public static final class ContainerAnalysisV1Beta1Stub
      extends io.grpc.stub.AbstractAsyncStub<ContainerAnalysisV1Beta1Stub> {
    private ContainerAnalysisV1Beta1Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisV1Beta1Stub(channel, callOptions);
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified scan configuration.
     * </pre>
     */
    public void getScanConfig(
        com.google.containeranalysis.v1beta1.GetScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ScanConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScanConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists scan configurations for the specified project.
     * </pre>
     */
    public void listScanConfigs(
        com.google.containeranalysis.v1beta1.ListScanConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListScanConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified scan configuration.
     * </pre>
     */
    public void updateScanConfig(
        com.google.containeranalysis.v1beta1.UpdateScanConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ScanConfig>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
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
  public static final class ContainerAnalysisV1Beta1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContainerAnalysisV1Beta1BlockingStub> {
    private ContainerAnalysisV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisV1Beta1BlockingStub(channel, callOptions);
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
      return blockingUnaryCall(getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified scan configuration.
     * </pre>
     */
    public com.google.containeranalysis.v1beta1.ScanConfig getScanConfig(
        com.google.containeranalysis.v1beta1.GetScanConfigRequest request) {
      return blockingUnaryCall(getChannel(), getGetScanConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists scan configurations for the specified project.
     * </pre>
     */
    public com.google.containeranalysis.v1beta1.ListScanConfigsResponse listScanConfigs(
        com.google.containeranalysis.v1beta1.ListScanConfigsRequest request) {
      return blockingUnaryCall(getChannel(), getListScanConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified scan configuration.
     * </pre>
     */
    public com.google.containeranalysis.v1beta1.ScanConfig updateScanConfig(
        com.google.containeranalysis.v1beta1.UpdateScanConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateScanConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Retrieves analysis results of Cloud components such as Docker container
   * images. The Container Analysis API is an implementation of the
   * [Grafeas](grafeas.io) API.
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
  public static final class ContainerAnalysisV1Beta1FutureStub
      extends io.grpc.stub.AbstractFutureStub<ContainerAnalysisV1Beta1FutureStub> {
    private ContainerAnalysisV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContainerAnalysisV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContainerAnalysisV1Beta1FutureStub(channel, callOptions);
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the specified scan configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.containeranalysis.v1beta1.ScanConfig>
        getScanConfig(com.google.containeranalysis.v1beta1.GetScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScanConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists scan configurations for the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.containeranalysis.v1beta1.ListScanConfigsResponse>
        listScanConfigs(com.google.containeranalysis.v1beta1.ListScanConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListScanConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified scan configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.containeranalysis.v1beta1.ScanConfig>
        updateScanConfig(com.google.containeranalysis.v1beta1.UpdateScanConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateScanConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_IAM_POLICY = 0;
  private static final int METHODID_GET_IAM_POLICY = 1;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 2;
  private static final int METHODID_GET_SCAN_CONFIG = 3;
  private static final int METHODID_LIST_SCAN_CONFIGS = 4;
  private static final int METHODID_UPDATE_SCAN_CONFIG = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ContainerAnalysisV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ContainerAnalysisV1Beta1ImplBase serviceImpl, int methodId) {
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
        case METHODID_GET_SCAN_CONFIG:
          serviceImpl.getScanConfig(
              (com.google.containeranalysis.v1beta1.GetScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ScanConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_SCAN_CONFIGS:
          serviceImpl.listScanConfigs(
              (com.google.containeranalysis.v1beta1.ListScanConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.containeranalysis.v1beta1.ListScanConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SCAN_CONFIG:
          serviceImpl.updateScanConfig(
              (com.google.containeranalysis.v1beta1.UpdateScanConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.containeranalysis.v1beta1.ScanConfig>)
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

  private abstract static class ContainerAnalysisV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContainerAnalysisV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.containeranalysis.v1beta1.Containeranalysis.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContainerAnalysisV1Beta1");
    }
  }

  private static final class ContainerAnalysisV1Beta1FileDescriptorSupplier
      extends ContainerAnalysisV1Beta1BaseDescriptorSupplier {
    ContainerAnalysisV1Beta1FileDescriptorSupplier() {}
  }

  private static final class ContainerAnalysisV1Beta1MethodDescriptorSupplier
      extends ContainerAnalysisV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ContainerAnalysisV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (ContainerAnalysisV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContainerAnalysisV1Beta1FileDescriptorSupplier())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getGetScanConfigMethod())
                      .addMethod(getListScanConfigsMethod())
                      .addMethod(getUpdateScanConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
