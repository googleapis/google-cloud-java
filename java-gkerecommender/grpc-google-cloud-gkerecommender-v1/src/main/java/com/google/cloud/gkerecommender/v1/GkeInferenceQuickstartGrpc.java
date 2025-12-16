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
package com.google.cloud.gkerecommender.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * GKE Inference Quickstart (GIQ) service provides profiles with performance
 * metrics for popular models and model servers across multiple accelerators.
 * These profiles help generate optimized best practices for running inference
 * on GKE.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class GkeInferenceQuickstartGrpc {

  private GkeInferenceQuickstartGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.gkerecommender.v1.GkeInferenceQuickstart";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchModelsRequest,
          com.google.cloud.gkerecommender.v1.FetchModelsResponse>
      getFetchModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchModels",
      requestType = com.google.cloud.gkerecommender.v1.FetchModelsRequest.class,
      responseType = com.google.cloud.gkerecommender.v1.FetchModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchModelsRequest,
          com.google.cloud.gkerecommender.v1.FetchModelsResponse>
      getFetchModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkerecommender.v1.FetchModelsRequest,
            com.google.cloud.gkerecommender.v1.FetchModelsResponse>
        getFetchModelsMethod;
    if ((getFetchModelsMethod = GkeInferenceQuickstartGrpc.getFetchModelsMethod) == null) {
      synchronized (GkeInferenceQuickstartGrpc.class) {
        if ((getFetchModelsMethod = GkeInferenceQuickstartGrpc.getFetchModelsMethod) == null) {
          GkeInferenceQuickstartGrpc.getFetchModelsMethod =
              getFetchModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkerecommender.v1.FetchModelsRequest,
                          com.google.cloud.gkerecommender.v1.FetchModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeInferenceQuickstartMethodDescriptorSupplier("FetchModels"))
                      .build();
        }
      }
    }
    return getFetchModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchModelServersRequest,
          com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
      getFetchModelServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchModelServers",
      requestType = com.google.cloud.gkerecommender.v1.FetchModelServersRequest.class,
      responseType = com.google.cloud.gkerecommender.v1.FetchModelServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchModelServersRequest,
          com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
      getFetchModelServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkerecommender.v1.FetchModelServersRequest,
            com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
        getFetchModelServersMethod;
    if ((getFetchModelServersMethod = GkeInferenceQuickstartGrpc.getFetchModelServersMethod)
        == null) {
      synchronized (GkeInferenceQuickstartGrpc.class) {
        if ((getFetchModelServersMethod = GkeInferenceQuickstartGrpc.getFetchModelServersMethod)
            == null) {
          GkeInferenceQuickstartGrpc.getFetchModelServersMethod =
              getFetchModelServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkerecommender.v1.FetchModelServersRequest,
                          com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchModelServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchModelServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchModelServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeInferenceQuickstartMethodDescriptorSupplier("FetchModelServers"))
                      .build();
        }
      }
    }
    return getFetchModelServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest,
          com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
      getFetchModelServerVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchModelServerVersions",
      requestType = com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest.class,
      responseType = com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest,
          com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
      getFetchModelServerVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest,
            com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
        getFetchModelServerVersionsMethod;
    if ((getFetchModelServerVersionsMethod =
            GkeInferenceQuickstartGrpc.getFetchModelServerVersionsMethod)
        == null) {
      synchronized (GkeInferenceQuickstartGrpc.class) {
        if ((getFetchModelServerVersionsMethod =
                GkeInferenceQuickstartGrpc.getFetchModelServerVersionsMethod)
            == null) {
          GkeInferenceQuickstartGrpc.getFetchModelServerVersionsMethod =
              getFetchModelServerVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest,
                          com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchModelServerVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeInferenceQuickstartMethodDescriptorSupplier(
                              "FetchModelServerVersions"))
                      .build();
        }
      }
    }
    return getFetchModelServerVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchProfilesRequest,
          com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
      getFetchProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchProfiles",
      requestType = com.google.cloud.gkerecommender.v1.FetchProfilesRequest.class,
      responseType = com.google.cloud.gkerecommender.v1.FetchProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchProfilesRequest,
          com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
      getFetchProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkerecommender.v1.FetchProfilesRequest,
            com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
        getFetchProfilesMethod;
    if ((getFetchProfilesMethod = GkeInferenceQuickstartGrpc.getFetchProfilesMethod) == null) {
      synchronized (GkeInferenceQuickstartGrpc.class) {
        if ((getFetchProfilesMethod = GkeInferenceQuickstartGrpc.getFetchProfilesMethod) == null) {
          GkeInferenceQuickstartGrpc.getFetchProfilesMethod =
              getFetchProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkerecommender.v1.FetchProfilesRequest,
                          com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeInferenceQuickstartMethodDescriptorSupplier("FetchProfiles"))
                      .build();
        }
      }
    }
    return getFetchProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest,
          com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
      getGenerateOptimizedManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateOptimizedManifest",
      requestType = com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest.class,
      responseType = com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest,
          com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
      getGenerateOptimizedManifestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest,
            com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
        getGenerateOptimizedManifestMethod;
    if ((getGenerateOptimizedManifestMethod =
            GkeInferenceQuickstartGrpc.getGenerateOptimizedManifestMethod)
        == null) {
      synchronized (GkeInferenceQuickstartGrpc.class) {
        if ((getGenerateOptimizedManifestMethod =
                GkeInferenceQuickstartGrpc.getGenerateOptimizedManifestMethod)
            == null) {
          GkeInferenceQuickstartGrpc.getGenerateOptimizedManifestMethod =
              getGenerateOptimizedManifestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest,
                          com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateOptimizedManifest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeInferenceQuickstartMethodDescriptorSupplier(
                              "GenerateOptimizedManifest"))
                      .build();
        }
      }
    }
    return getGenerateOptimizedManifestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest,
          com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
      getFetchBenchmarkingDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchBenchmarkingData",
      requestType = com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest.class,
      responseType = com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest,
          com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
      getFetchBenchmarkingDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest,
            com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
        getFetchBenchmarkingDataMethod;
    if ((getFetchBenchmarkingDataMethod = GkeInferenceQuickstartGrpc.getFetchBenchmarkingDataMethod)
        == null) {
      synchronized (GkeInferenceQuickstartGrpc.class) {
        if ((getFetchBenchmarkingDataMethod =
                GkeInferenceQuickstartGrpc.getFetchBenchmarkingDataMethod)
            == null) {
          GkeInferenceQuickstartGrpc.getFetchBenchmarkingDataMethod =
              getFetchBenchmarkingDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest,
                          com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchBenchmarkingData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GkeInferenceQuickstartMethodDescriptorSupplier(
                              "FetchBenchmarkingData"))
                      .build();
        }
      }
    }
    return getFetchBenchmarkingDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GkeInferenceQuickstartStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartStub>() {
          @java.lang.Override
          public GkeInferenceQuickstartStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeInferenceQuickstartStub(channel, callOptions);
          }
        };
    return GkeInferenceQuickstartStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static GkeInferenceQuickstartBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartBlockingV2Stub>() {
          @java.lang.Override
          public GkeInferenceQuickstartBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeInferenceQuickstartBlockingV2Stub(channel, callOptions);
          }
        };
    return GkeInferenceQuickstartBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GkeInferenceQuickstartBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartBlockingStub>() {
          @java.lang.Override
          public GkeInferenceQuickstartBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeInferenceQuickstartBlockingStub(channel, callOptions);
          }
        };
    return GkeInferenceQuickstartBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GkeInferenceQuickstartFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GkeInferenceQuickstartFutureStub>() {
          @java.lang.Override
          public GkeInferenceQuickstartFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GkeInferenceQuickstartFutureStub(channel, callOptions);
          }
        };
    return GkeInferenceQuickstartFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * GKE Inference Quickstart (GIQ) service provides profiles with performance
   * metrics for popular models and model servers across multiple accelerators.
   * These profiles help generate optimized best practices for running inference
   * on GKE.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Fetches available models. Open-source models follow the Huggingface Hub
     * `owner/model_name` format.
     * </pre>
     */
    default void fetchModels(
        com.google.cloud.gkerecommender.v1.FetchModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model servers. Open-source model servers use simplified,
     * lowercase names (e.g., `vllm`).
     * </pre>
     */
    default void fetchModelServers(
        com.google.cloud.gkerecommender.v1.FetchModelServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchModelServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model server versions. Open-source servers use their own
     * versioning schemas (e.g., `vllm` uses semver like `v1.0.0`).
     * Some model servers have different versioning schemas depending on the
     * accelerator. For example, `vllm` uses semver on GPUs, but returns nightly
     * build tags on TPUs. All available versions will be returned when different
     * schemas are present.
     * </pre>
     */
    default void fetchModelServerVersions(
        com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchModelServerVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available profiles. A profile contains performance metrics and
     * cost information for a specific model server setup. Profiles can be
     * filtered by parameters. If no filters are provided, all profiles are
     * returned.
     * Profiles display a single value per performance metric based on the
     * provided performance requirements. If no requirements are given, the
     * metrics represent the inflection point. See [Run best practice inference
     * with GKE Inference Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
     * for details.
     * </pre>
     */
    default void fetchProfiles(
        com.google.cloud.gkerecommender.v1.FetchProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an optimized deployment manifest for a given model and model
     * server, based on the specified accelerator, performance targets, and
     * configurations. See [Run best practice inference with GKE Inference
     * Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
     * for deployment details.
     * </pre>
     */
    default void generateOptimizedManifest(
        com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateOptimizedManifestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches all of the benchmarking data available for a profile. Benchmarking
     * data returns all of the performance metrics available for a given model
     * server setup on a given instance type.
     * </pre>
     */
    default void fetchBenchmarkingData(
        com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchBenchmarkingDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GkeInferenceQuickstart.
   *
   * <pre>
   * GKE Inference Quickstart (GIQ) service provides profiles with performance
   * metrics for popular models and model servers across multiple accelerators.
   * These profiles help generate optimized best practices for running inference
   * on GKE.
   * </pre>
   */
  public abstract static class GkeInferenceQuickstartImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GkeInferenceQuickstartGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GkeInferenceQuickstart.
   *
   * <pre>
   * GKE Inference Quickstart (GIQ) service provides profiles with performance
   * metrics for popular models and model servers across multiple accelerators.
   * These profiles help generate optimized best practices for running inference
   * on GKE.
   * </pre>
   */
  public static final class GkeInferenceQuickstartStub
      extends io.grpc.stub.AbstractAsyncStub<GkeInferenceQuickstartStub> {
    private GkeInferenceQuickstartStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeInferenceQuickstartStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeInferenceQuickstartStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches available models. Open-source models follow the Huggingface Hub
     * `owner/model_name` format.
     * </pre>
     */
    public void fetchModels(
        com.google.cloud.gkerecommender.v1.FetchModelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchModelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model servers. Open-source model servers use simplified,
     * lowercase names (e.g., `vllm`).
     * </pre>
     */
    public void fetchModelServers(
        com.google.cloud.gkerecommender.v1.FetchModelServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchModelServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model server versions. Open-source servers use their own
     * versioning schemas (e.g., `vllm` uses semver like `v1.0.0`).
     * Some model servers have different versioning schemas depending on the
     * accelerator. For example, `vllm` uses semver on GPUs, but returns nightly
     * build tags on TPUs. All available versions will be returned when different
     * schemas are present.
     * </pre>
     */
    public void fetchModelServerVersions(
        com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchModelServerVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches available profiles. A profile contains performance metrics and
     * cost information for a specific model server setup. Profiles can be
     * filtered by parameters. If no filters are provided, all profiles are
     * returned.
     * Profiles display a single value per performance metric based on the
     * provided performance requirements. If no requirements are given, the
     * metrics represent the inflection point. See [Run best practice inference
     * with GKE Inference Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
     * for details.
     * </pre>
     */
    public void fetchProfiles(
        com.google.cloud.gkerecommender.v1.FetchProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an optimized deployment manifest for a given model and model
     * server, based on the specified accelerator, performance targets, and
     * configurations. See [Run best practice inference with GKE Inference
     * Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
     * for deployment details.
     * </pre>
     */
    public void generateOptimizedManifest(
        com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateOptimizedManifestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches all of the benchmarking data available for a profile. Benchmarking
     * data returns all of the performance metrics available for a given model
     * server setup on a given instance type.
     * </pre>
     */
    public void fetchBenchmarkingData(
        com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchBenchmarkingDataMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GkeInferenceQuickstart.
   *
   * <pre>
   * GKE Inference Quickstart (GIQ) service provides profiles with performance
   * metrics for popular models and model servers across multiple accelerators.
   * These profiles help generate optimized best practices for running inference
   * on GKE.
   * </pre>
   */
  public static final class GkeInferenceQuickstartBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<GkeInferenceQuickstartBlockingV2Stub> {
    private GkeInferenceQuickstartBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeInferenceQuickstartBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeInferenceQuickstartBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches available models. Open-source models follow the Huggingface Hub
     * `owner/model_name` format.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchModelsResponse fetchModels(
        com.google.cloud.gkerecommender.v1.FetchModelsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model servers. Open-source model servers use simplified,
     * lowercase names (e.g., `vllm`).
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchModelServersResponse fetchModelServers(
        com.google.cloud.gkerecommender.v1.FetchModelServersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchModelServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model server versions. Open-source servers use their own
     * versioning schemas (e.g., `vllm` uses semver like `v1.0.0`).
     * Some model servers have different versioning schemas depending on the
     * accelerator. For example, `vllm` uses semver on GPUs, but returns nightly
     * build tags on TPUs. All available versions will be returned when different
     * schemas are present.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse
        fetchModelServerVersions(
            com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchModelServerVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available profiles. A profile contains performance metrics and
     * cost information for a specific model server setup. Profiles can be
     * filtered by parameters. If no filters are provided, all profiles are
     * returned.
     * Profiles display a single value per performance metric based on the
     * provided performance requirements. If no requirements are given, the
     * metrics represent the inflection point. See [Run best practice inference
     * with GKE Inference Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
     * for details.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchProfilesResponse fetchProfiles(
        com.google.cloud.gkerecommender.v1.FetchProfilesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates an optimized deployment manifest for a given model and model
     * server, based on the specified accelerator, performance targets, and
     * configurations. See [Run best practice inference with GKE Inference
     * Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
     * for deployment details.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse
        generateOptimizedManifest(
            com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateOptimizedManifestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all of the benchmarking data available for a profile. Benchmarking
     * data returns all of the performance metrics available for a given model
     * server setup on a given instance type.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse fetchBenchmarkingData(
        com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchBenchmarkingDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service GkeInferenceQuickstart.
   *
   * <pre>
   * GKE Inference Quickstart (GIQ) service provides profiles with performance
   * metrics for popular models and model servers across multiple accelerators.
   * These profiles help generate optimized best practices for running inference
   * on GKE.
   * </pre>
   */
  public static final class GkeInferenceQuickstartBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GkeInferenceQuickstartBlockingStub> {
    private GkeInferenceQuickstartBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeInferenceQuickstartBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeInferenceQuickstartBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches available models. Open-source models follow the Huggingface Hub
     * `owner/model_name` format.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchModelsResponse fetchModels(
        com.google.cloud.gkerecommender.v1.FetchModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model servers. Open-source model servers use simplified,
     * lowercase names (e.g., `vllm`).
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchModelServersResponse fetchModelServers(
        com.google.cloud.gkerecommender.v1.FetchModelServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchModelServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model server versions. Open-source servers use their own
     * versioning schemas (e.g., `vllm` uses semver like `v1.0.0`).
     * Some model servers have different versioning schemas depending on the
     * accelerator. For example, `vllm` uses semver on GPUs, but returns nightly
     * build tags on TPUs. All available versions will be returned when different
     * schemas are present.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse
        fetchModelServerVersions(
            com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchModelServerVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available profiles. A profile contains performance metrics and
     * cost information for a specific model server setup. Profiles can be
     * filtered by parameters. If no filters are provided, all profiles are
     * returned.
     * Profiles display a single value per performance metric based on the
     * provided performance requirements. If no requirements are given, the
     * metrics represent the inflection point. See [Run best practice inference
     * with GKE Inference Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
     * for details.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchProfilesResponse fetchProfiles(
        com.google.cloud.gkerecommender.v1.FetchProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates an optimized deployment manifest for a given model and model
     * server, based on the specified accelerator, performance targets, and
     * configurations. See [Run best practice inference with GKE Inference
     * Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
     * for deployment details.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse
        generateOptimizedManifest(
            com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateOptimizedManifestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all of the benchmarking data available for a profile. Benchmarking
     * data returns all of the performance metrics available for a given model
     * server setup on a given instance type.
     * </pre>
     */
    public com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse fetchBenchmarkingData(
        com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchBenchmarkingDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * GkeInferenceQuickstart.
   *
   * <pre>
   * GKE Inference Quickstart (GIQ) service provides profiles with performance
   * metrics for popular models and model servers across multiple accelerators.
   * These profiles help generate optimized best practices for running inference
   * on GKE.
   * </pre>
   */
  public static final class GkeInferenceQuickstartFutureStub
      extends io.grpc.stub.AbstractFutureStub<GkeInferenceQuickstartFutureStub> {
    private GkeInferenceQuickstartFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GkeInferenceQuickstartFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GkeInferenceQuickstartFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches available models. Open-source models follow the Huggingface Hub
     * `owner/model_name` format.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkerecommender.v1.FetchModelsResponse>
        fetchModels(com.google.cloud.gkerecommender.v1.FetchModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model servers. Open-source model servers use simplified,
     * lowercase names (e.g., `vllm`).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkerecommender.v1.FetchModelServersResponse>
        fetchModelServers(com.google.cloud.gkerecommender.v1.FetchModelServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchModelServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available model server versions. Open-source servers use their own
     * versioning schemas (e.g., `vllm` uses semver like `v1.0.0`).
     * Some model servers have different versioning schemas depending on the
     * accelerator. For example, `vllm` uses semver on GPUs, but returns nightly
     * build tags on TPUs. All available versions will be returned when different
     * schemas are present.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>
        fetchModelServerVersions(
            com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchModelServerVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches available profiles. A profile contains performance metrics and
     * cost information for a specific model server setup. Profiles can be
     * filtered by parameters. If no filters are provided, all profiles are
     * returned.
     * Profiles display a single value per performance metric based on the
     * provided performance requirements. If no requirements are given, the
     * metrics represent the inflection point. See [Run best practice inference
     * with GKE Inference Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart#how)
     * for details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkerecommender.v1.FetchProfilesResponse>
        fetchProfiles(com.google.cloud.gkerecommender.v1.FetchProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates an optimized deployment manifest for a given model and model
     * server, based on the specified accelerator, performance targets, and
     * configurations. See [Run best practice inference with GKE Inference
     * Quickstart
     * recipes](https://cloud.google.com/kubernetes-engine/docs/how-to/machine-learning/inference/inference-quickstart)
     * for deployment details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>
        generateOptimizedManifest(
            com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateOptimizedManifestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all of the benchmarking data available for a profile. Benchmarking
     * data returns all of the performance metrics available for a given model
     * server setup on a given instance type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>
        fetchBenchmarkingData(
            com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchBenchmarkingDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_MODELS = 0;
  private static final int METHODID_FETCH_MODEL_SERVERS = 1;
  private static final int METHODID_FETCH_MODEL_SERVER_VERSIONS = 2;
  private static final int METHODID_FETCH_PROFILES = 3;
  private static final int METHODID_GENERATE_OPTIMIZED_MANIFEST = 4;
  private static final int METHODID_FETCH_BENCHMARKING_DATA = 5;

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
        case METHODID_FETCH_MODELS:
          serviceImpl.fetchModels(
              (com.google.cloud.gkerecommender.v1.FetchModelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkerecommender.v1.FetchModelsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_MODEL_SERVERS:
          serviceImpl.fetchModelServers(
              (com.google.cloud.gkerecommender.v1.FetchModelServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkerecommender.v1.FetchModelServersResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_MODEL_SERVER_VERSIONS:
          serviceImpl.fetchModelServerVersions(
              (com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_PROFILES:
          serviceImpl.fetchProfiles(
              (com.google.cloud.gkerecommender.v1.FetchProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkerecommender.v1.FetchProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_OPTIMIZED_MANIFEST:
          serviceImpl.generateOptimizedManifest(
              (com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_BENCHMARKING_DATA:
          serviceImpl.fetchBenchmarkingData(
              (com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>)
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
            getFetchModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkerecommender.v1.FetchModelsRequest,
                    com.google.cloud.gkerecommender.v1.FetchModelsResponse>(
                    service, METHODID_FETCH_MODELS)))
        .addMethod(
            getFetchModelServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkerecommender.v1.FetchModelServersRequest,
                    com.google.cloud.gkerecommender.v1.FetchModelServersResponse>(
                    service, METHODID_FETCH_MODEL_SERVERS)))
        .addMethod(
            getFetchModelServerVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest,
                    com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse>(
                    service, METHODID_FETCH_MODEL_SERVER_VERSIONS)))
        .addMethod(
            getFetchProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkerecommender.v1.FetchProfilesRequest,
                    com.google.cloud.gkerecommender.v1.FetchProfilesResponse>(
                    service, METHODID_FETCH_PROFILES)))
        .addMethod(
            getGenerateOptimizedManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest,
                    com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse>(
                    service, METHODID_GENERATE_OPTIMIZED_MANIFEST)))
        .addMethod(
            getFetchBenchmarkingDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest,
                    com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse>(
                    service, METHODID_FETCH_BENCHMARKING_DATA)))
        .build();
  }

  private abstract static class GkeInferenceQuickstartBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GkeInferenceQuickstartBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkerecommender.v1.GkeRecommenderProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GkeInferenceQuickstart");
    }
  }

  private static final class GkeInferenceQuickstartFileDescriptorSupplier
      extends GkeInferenceQuickstartBaseDescriptorSupplier {
    GkeInferenceQuickstartFileDescriptorSupplier() {}
  }

  private static final class GkeInferenceQuickstartMethodDescriptorSupplier
      extends GkeInferenceQuickstartBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GkeInferenceQuickstartMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GkeInferenceQuickstartGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GkeInferenceQuickstartFileDescriptorSupplier())
                      .addMethod(getFetchModelsMethod())
                      .addMethod(getFetchModelServersMethod())
                      .addMethod(getFetchModelServerVersionsMethod())
                      .addMethod(getFetchProfilesMethod())
                      .addMethod(getGenerateOptimizedManifestMethod())
                      .addMethod(getFetchBenchmarkingDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
