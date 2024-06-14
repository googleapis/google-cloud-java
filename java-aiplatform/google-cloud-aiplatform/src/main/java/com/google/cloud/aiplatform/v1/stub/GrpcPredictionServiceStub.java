/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.PredictionServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.DirectPredictRequest;
import com.google.cloud.aiplatform.v1.DirectPredictResponse;
import com.google.cloud.aiplatform.v1.DirectRawPredictRequest;
import com.google.cloud.aiplatform.v1.DirectRawPredictResponse;
import com.google.cloud.aiplatform.v1.ExplainRequest;
import com.google.cloud.aiplatform.v1.ExplainResponse;
import com.google.cloud.aiplatform.v1.GenerateContentRequest;
import com.google.cloud.aiplatform.v1.GenerateContentResponse;
import com.google.cloud.aiplatform.v1.PredictRequest;
import com.google.cloud.aiplatform.v1.PredictResponse;
import com.google.cloud.aiplatform.v1.RawPredictRequest;
import com.google.cloud.aiplatform.v1.StreamDirectPredictRequest;
import com.google.cloud.aiplatform.v1.StreamDirectPredictResponse;
import com.google.cloud.aiplatform.v1.StreamDirectRawPredictRequest;
import com.google.cloud.aiplatform.v1.StreamDirectRawPredictResponse;
import com.google.cloud.aiplatform.v1.StreamRawPredictRequest;
import com.google.cloud.aiplatform.v1.StreamingPredictRequest;
import com.google.cloud.aiplatform.v1.StreamingPredictResponse;
import com.google.cloud.aiplatform.v1.StreamingRawPredictRequest;
import com.google.cloud.aiplatform.v1.StreamingRawPredictResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PredictionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPredictionServiceStub extends PredictionServiceStub {
  private static final MethodDescriptor<PredictRequest, PredictResponse> predictMethodDescriptor =
      MethodDescriptor.<PredictRequest, PredictResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/Predict")
          .setRequestMarshaller(ProtoUtils.marshaller(PredictRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PredictResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RawPredictRequest, HttpBody> rawPredictMethodDescriptor =
      MethodDescriptor.<RawPredictRequest, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/RawPredict")
          .setRequestMarshaller(ProtoUtils.marshaller(RawPredictRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StreamRawPredictRequest, HttpBody>
      streamRawPredictMethodDescriptor =
          MethodDescriptor.<StreamRawPredictRequest, HttpBody>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/StreamRawPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamRawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DirectPredictRequest, DirectPredictResponse>
      directPredictMethodDescriptor =
          MethodDescriptor.<DirectPredictRequest, DirectPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/DirectPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DirectPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DirectPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictMethodDescriptor =
          MethodDescriptor.<DirectRawPredictRequest, DirectRawPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/DirectRawPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DirectRawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DirectRawPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictMethodDescriptor =
          MethodDescriptor.<StreamDirectPredictRequest, StreamDirectPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/StreamDirectPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamDirectPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamDirectPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictMethodDescriptor =
          MethodDescriptor
              .<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PredictionService/StreamDirectRawPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamDirectRawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamDirectRawPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictMethodDescriptor =
          MethodDescriptor.<StreamingPredictRequest, StreamingPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/StreamingPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictMethodDescriptor =
          MethodDescriptor.<StreamingPredictRequest, StreamingPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PredictionService/ServerStreamingPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictMethodDescriptor =
          MethodDescriptor.<StreamingRawPredictRequest, StreamingRawPredictResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/StreamingRawPredict")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingRawPredictRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingRawPredictResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExplainRequest, ExplainResponse> explainMethodDescriptor =
      MethodDescriptor.<ExplainRequest, ExplainResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/Explain")
          .setRequestMarshaller(ProtoUtils.marshaller(ExplainRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ExplainResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GenerateContentRequest, GenerateContentResponse>
      generateContentMethodDescriptor =
          MethodDescriptor.<GenerateContentRequest, GenerateContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PredictionService/GenerateContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentMethodDescriptor =
          MethodDescriptor.<GenerateContentRequest, GenerateContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PredictionService/StreamGenerateContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<PredictRequest, PredictResponse> predictCallable;
  private final UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable;
  private final ServerStreamingCallable<StreamRawPredictRequest, HttpBody> streamRawPredictCallable;
  private final UnaryCallable<DirectPredictRequest, DirectPredictResponse> directPredictCallable;
  private final UnaryCallable<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictCallable;
  private final BidiStreamingCallable<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictCallable;
  private final BidiStreamingCallable<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictCallable;
  private final BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictCallable;
  private final ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictCallable;
  private final BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictCallable;
  private final UnaryCallable<ExplainRequest, ExplainResponse> explainCallable;
  private final UnaryCallable<GenerateContentRequest, GenerateContentResponse>
      generateContentCallable;
  private final ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPredictionServiceStub create(PredictionServiceStubSettings settings)
      throws IOException {
    return new GrpcPredictionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPredictionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPredictionServiceStub(
        PredictionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPredictionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPredictionServiceStub(
        PredictionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPredictionServiceStub(
      PredictionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPredictionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPredictionServiceStub(
      PredictionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<PredictRequest, PredictResponse> predictTransportSettings =
        GrpcCallSettings.<PredictRequest, PredictResponse>newBuilder()
            .setMethodDescriptor(predictMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RawPredictRequest, HttpBody> rawPredictTransportSettings =
        GrpcCallSettings.<RawPredictRequest, HttpBody>newBuilder()
            .setMethodDescriptor(rawPredictMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StreamRawPredictRequest, HttpBody> streamRawPredictTransportSettings =
        GrpcCallSettings.<StreamRawPredictRequest, HttpBody>newBuilder()
            .setMethodDescriptor(streamRawPredictMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DirectPredictRequest, DirectPredictResponse> directPredictTransportSettings =
        GrpcCallSettings.<DirectPredictRequest, DirectPredictResponse>newBuilder()
            .setMethodDescriptor(directPredictMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DirectRawPredictRequest, DirectRawPredictResponse>
        directRawPredictTransportSettings =
            GrpcCallSettings.<DirectRawPredictRequest, DirectRawPredictResponse>newBuilder()
                .setMethodDescriptor(directRawPredictMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("endpoint", String.valueOf(request.getEndpoint()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StreamDirectPredictRequest, StreamDirectPredictResponse>
        streamDirectPredictTransportSettings =
            GrpcCallSettings.<StreamDirectPredictRequest, StreamDirectPredictResponse>newBuilder()
                .setMethodDescriptor(streamDirectPredictMethodDescriptor)
                .build();
    GrpcCallSettings<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
        streamDirectRawPredictTransportSettings =
            GrpcCallSettings
                .<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>newBuilder()
                .setMethodDescriptor(streamDirectRawPredictMethodDescriptor)
                .build();
    GrpcCallSettings<StreamingPredictRequest, StreamingPredictResponse>
        streamingPredictTransportSettings =
            GrpcCallSettings.<StreamingPredictRequest, StreamingPredictResponse>newBuilder()
                .setMethodDescriptor(streamingPredictMethodDescriptor)
                .build();
    GrpcCallSettings<StreamingPredictRequest, StreamingPredictResponse>
        serverStreamingPredictTransportSettings =
            GrpcCallSettings.<StreamingPredictRequest, StreamingPredictResponse>newBuilder()
                .setMethodDescriptor(serverStreamingPredictMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("endpoint", String.valueOf(request.getEndpoint()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StreamingRawPredictRequest, StreamingRawPredictResponse>
        streamingRawPredictTransportSettings =
            GrpcCallSettings.<StreamingRawPredictRequest, StreamingRawPredictResponse>newBuilder()
                .setMethodDescriptor(streamingRawPredictMethodDescriptor)
                .build();
    GrpcCallSettings<ExplainRequest, ExplainResponse> explainTransportSettings =
        GrpcCallSettings.<ExplainRequest, ExplainResponse>newBuilder()
            .setMethodDescriptor(explainMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateContentRequest, GenerateContentResponse>
        generateContentTransportSettings =
            GrpcCallSettings.<GenerateContentRequest, GenerateContentResponse>newBuilder()
                .setMethodDescriptor(generateContentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateContentRequest, GenerateContentResponse>
        streamGenerateContentTransportSettings =
            GrpcCallSettings.<GenerateContentRequest, GenerateContentResponse>newBuilder()
                .setMethodDescriptor(streamGenerateContentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.predictCallable =
        callableFactory.createUnaryCallable(
            predictTransportSettings, settings.predictSettings(), clientContext);
    this.rawPredictCallable =
        callableFactory.createUnaryCallable(
            rawPredictTransportSettings, settings.rawPredictSettings(), clientContext);
    this.streamRawPredictCallable =
        callableFactory.createServerStreamingCallable(
            streamRawPredictTransportSettings, settings.streamRawPredictSettings(), clientContext);
    this.directPredictCallable =
        callableFactory.createUnaryCallable(
            directPredictTransportSettings, settings.directPredictSettings(), clientContext);
    this.directRawPredictCallable =
        callableFactory.createUnaryCallable(
            directRawPredictTransportSettings, settings.directRawPredictSettings(), clientContext);
    this.streamDirectPredictCallable =
        callableFactory.createBidiStreamingCallable(
            streamDirectPredictTransportSettings,
            settings.streamDirectPredictSettings(),
            clientContext);
    this.streamDirectRawPredictCallable =
        callableFactory.createBidiStreamingCallable(
            streamDirectRawPredictTransportSettings,
            settings.streamDirectRawPredictSettings(),
            clientContext);
    this.streamingPredictCallable =
        callableFactory.createBidiStreamingCallable(
            streamingPredictTransportSettings, settings.streamingPredictSettings(), clientContext);
    this.serverStreamingPredictCallable =
        callableFactory.createServerStreamingCallable(
            serverStreamingPredictTransportSettings,
            settings.serverStreamingPredictSettings(),
            clientContext);
    this.streamingRawPredictCallable =
        callableFactory.createBidiStreamingCallable(
            streamingRawPredictTransportSettings,
            settings.streamingRawPredictSettings(),
            clientContext);
    this.explainCallable =
        callableFactory.createUnaryCallable(
            explainTransportSettings, settings.explainSettings(), clientContext);
    this.generateContentCallable =
        callableFactory.createUnaryCallable(
            generateContentTransportSettings, settings.generateContentSettings(), clientContext);
    this.streamGenerateContentCallable =
        callableFactory.createServerStreamingCallable(
            streamGenerateContentTransportSettings,
            settings.streamGenerateContentSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return predictCallable;
  }

  @Override
  public UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable() {
    return rawPredictCallable;
  }

  @Override
  public ServerStreamingCallable<StreamRawPredictRequest, HttpBody> streamRawPredictCallable() {
    return streamRawPredictCallable;
  }

  @Override
  public UnaryCallable<DirectPredictRequest, DirectPredictResponse> directPredictCallable() {
    return directPredictCallable;
  }

  @Override
  public UnaryCallable<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictCallable() {
    return directRawPredictCallable;
  }

  @Override
  public BidiStreamingCallable<StreamDirectPredictRequest, StreamDirectPredictResponse>
      streamDirectPredictCallable() {
    return streamDirectPredictCallable;
  }

  @Override
  public BidiStreamingCallable<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse>
      streamDirectRawPredictCallable() {
    return streamDirectRawPredictCallable;
  }

  @Override
  public BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictCallable() {
    return streamingPredictCallable;
  }

  @Override
  public ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictCallable() {
    return serverStreamingPredictCallable;
  }

  @Override
  public BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictCallable() {
    return streamingRawPredictCallable;
  }

  @Override
  public UnaryCallable<ExplainRequest, ExplainResponse> explainCallable() {
    return explainCallable;
  }

  @Override
  public UnaryCallable<GenerateContentRequest, GenerateContentResponse> generateContentCallable() {
    return generateContentCallable;
  }

  @Override
  public ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentCallable() {
    return streamGenerateContentCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
