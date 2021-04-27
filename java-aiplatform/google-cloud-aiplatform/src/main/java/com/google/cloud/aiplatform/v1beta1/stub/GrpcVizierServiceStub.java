/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListStudiesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VizierServiceClient.ListTrialsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AddTrialMeasurementRequest;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateMetatdata;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateRequest;
import com.google.cloud.aiplatform.v1beta1.CheckTrialEarlyStoppingStateResponse;
import com.google.cloud.aiplatform.v1beta1.CompleteTrialRequest;
import com.google.cloud.aiplatform.v1beta1.CreateStudyRequest;
import com.google.cloud.aiplatform.v1beta1.CreateTrialRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteStudyRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteTrialRequest;
import com.google.cloud.aiplatform.v1beta1.GetStudyRequest;
import com.google.cloud.aiplatform.v1beta1.GetTrialRequest;
import com.google.cloud.aiplatform.v1beta1.ListOptimalTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.ListOptimalTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.ListStudiesRequest;
import com.google.cloud.aiplatform.v1beta1.ListStudiesResponse;
import com.google.cloud.aiplatform.v1beta1.ListTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.ListTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.LookupStudyRequest;
import com.google.cloud.aiplatform.v1beta1.StopTrialRequest;
import com.google.cloud.aiplatform.v1beta1.Study;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsMetadata;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsRequest;
import com.google.cloud.aiplatform.v1beta1.SuggestTrialsResponse;
import com.google.cloud.aiplatform.v1beta1.Trial;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the VizierService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcVizierServiceStub extends VizierServiceStub {
  private static final MethodDescriptor<CreateStudyRequest, Study> createStudyMethodDescriptor =
      MethodDescriptor.<CreateStudyRequest, Study>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/CreateStudy")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateStudyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Study.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetStudyRequest, Study> getStudyMethodDescriptor =
      MethodDescriptor.<GetStudyRequest, Study>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/GetStudy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetStudyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Study.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListStudiesRequest, ListStudiesResponse>
      listStudiesMethodDescriptor =
          MethodDescriptor.<ListStudiesRequest, ListStudiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/ListStudies")
              .setRequestMarshaller(ProtoUtils.marshaller(ListStudiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStudiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteStudyRequest, Empty> deleteStudyMethodDescriptor =
      MethodDescriptor.<DeleteStudyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/DeleteStudy")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteStudyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<LookupStudyRequest, Study> lookupStudyMethodDescriptor =
      MethodDescriptor.<LookupStudyRequest, Study>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/LookupStudy")
          .setRequestMarshaller(ProtoUtils.marshaller(LookupStudyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Study.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SuggestTrialsRequest, Operation>
      suggestTrialsMethodDescriptor =
          MethodDescriptor.<SuggestTrialsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/SuggestTrials")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuggestTrialsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTrialRequest, Trial> createTrialMethodDescriptor =
      MethodDescriptor.<CreateTrialRequest, Trial>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/CreateTrial")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTrialRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trial.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetTrialRequest, Trial> getTrialMethodDescriptor =
      MethodDescriptor.<GetTrialRequest, Trial>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/GetTrial")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTrialRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trial.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTrialsRequest, ListTrialsResponse>
      listTrialsMethodDescriptor =
          MethodDescriptor.<ListTrialsRequest, ListTrialsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/ListTrials")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTrialsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTrialsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddTrialMeasurementRequest, Trial>
      addTrialMeasurementMethodDescriptor =
          MethodDescriptor.<AddTrialMeasurementRequest, Trial>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VizierService/AddTrialMeasurement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddTrialMeasurementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Trial.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompleteTrialRequest, Trial> completeTrialMethodDescriptor =
      MethodDescriptor.<CompleteTrialRequest, Trial>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/CompleteTrial")
          .setRequestMarshaller(ProtoUtils.marshaller(CompleteTrialRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trial.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTrialRequest, Empty> deleteTrialMethodDescriptor =
      MethodDescriptor.<DeleteTrialRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/DeleteTrial")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTrialRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateMethodDescriptor =
          MethodDescriptor.<CheckTrialEarlyStoppingStateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VizierService/CheckTrialEarlyStoppingState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckTrialEarlyStoppingStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopTrialRequest, Trial> stopTrialMethodDescriptor =
      MethodDescriptor.<StopTrialRequest, Trial>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/StopTrial")
          .setRequestMarshaller(ProtoUtils.marshaller(StopTrialRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trial.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsMethodDescriptor =
          MethodDescriptor.<ListOptimalTrialsRequest, ListOptimalTrialsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.VizierService/ListOptimalTrials")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOptimalTrialsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOptimalTrialsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateStudyRequest, Study> createStudyCallable;
  private final UnaryCallable<GetStudyRequest, Study> getStudyCallable;
  private final UnaryCallable<ListStudiesRequest, ListStudiesResponse> listStudiesCallable;
  private final UnaryCallable<ListStudiesRequest, ListStudiesPagedResponse>
      listStudiesPagedCallable;
  private final UnaryCallable<DeleteStudyRequest, Empty> deleteStudyCallable;
  private final UnaryCallable<LookupStudyRequest, Study> lookupStudyCallable;
  private final UnaryCallable<SuggestTrialsRequest, Operation> suggestTrialsCallable;
  private final OperationCallable<
          SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationCallable;
  private final UnaryCallable<CreateTrialRequest, Trial> createTrialCallable;
  private final UnaryCallable<GetTrialRequest, Trial> getTrialCallable;
  private final UnaryCallable<ListTrialsRequest, ListTrialsResponse> listTrialsCallable;
  private final UnaryCallable<ListTrialsRequest, ListTrialsPagedResponse> listTrialsPagedCallable;
  private final UnaryCallable<AddTrialMeasurementRequest, Trial> addTrialMeasurementCallable;
  private final UnaryCallable<CompleteTrialRequest, Trial> completeTrialCallable;
  private final UnaryCallable<DeleteTrialRequest, Empty> deleteTrialCallable;
  private final UnaryCallable<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateCallable;
  private final OperationCallable<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationCallable;
  private final UnaryCallable<StopTrialRequest, Trial> stopTrialCallable;
  private final UnaryCallable<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVizierServiceStub create(VizierServiceStubSettings settings)
      throws IOException {
    return new GrpcVizierServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVizierServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcVizierServiceStub(VizierServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVizierServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVizierServiceStub(
        VizierServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVizierServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVizierServiceStub(VizierServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcVizierServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVizierServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVizierServiceStub(
      VizierServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateStudyRequest, Study> createStudyTransportSettings =
        GrpcCallSettings.<CreateStudyRequest, Study>newBuilder()
            .setMethodDescriptor(createStudyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateStudyRequest>() {
                  @Override
                  public Map<String, String> extract(CreateStudyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetStudyRequest, Study> getStudyTransportSettings =
        GrpcCallSettings.<GetStudyRequest, Study>newBuilder()
            .setMethodDescriptor(getStudyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetStudyRequest>() {
                  @Override
                  public Map<String, String> extract(GetStudyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListStudiesRequest, ListStudiesResponse> listStudiesTransportSettings =
        GrpcCallSettings.<ListStudiesRequest, ListStudiesResponse>newBuilder()
            .setMethodDescriptor(listStudiesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListStudiesRequest>() {
                  @Override
                  public Map<String, String> extract(ListStudiesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteStudyRequest, Empty> deleteStudyTransportSettings =
        GrpcCallSettings.<DeleteStudyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStudyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteStudyRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteStudyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<LookupStudyRequest, Study> lookupStudyTransportSettings =
        GrpcCallSettings.<LookupStudyRequest, Study>newBuilder()
            .setMethodDescriptor(lookupStudyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<LookupStudyRequest>() {
                  @Override
                  public Map<String, String> extract(LookupStudyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SuggestTrialsRequest, Operation> suggestTrialsTransportSettings =
        GrpcCallSettings.<SuggestTrialsRequest, Operation>newBuilder()
            .setMethodDescriptor(suggestTrialsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SuggestTrialsRequest>() {
                  @Override
                  public Map<String, String> extract(SuggestTrialsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTrialRequest, Trial> createTrialTransportSettings =
        GrpcCallSettings.<CreateTrialRequest, Trial>newBuilder()
            .setMethodDescriptor(createTrialMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTrialRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTrialRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTrialRequest, Trial> getTrialTransportSettings =
        GrpcCallSettings.<GetTrialRequest, Trial>newBuilder()
            .setMethodDescriptor(getTrialMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTrialRequest>() {
                  @Override
                  public Map<String, String> extract(GetTrialRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTrialsRequest, ListTrialsResponse> listTrialsTransportSettings =
        GrpcCallSettings.<ListTrialsRequest, ListTrialsResponse>newBuilder()
            .setMethodDescriptor(listTrialsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTrialsRequest>() {
                  @Override
                  public Map<String, String> extract(ListTrialsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<AddTrialMeasurementRequest, Trial> addTrialMeasurementTransportSettings =
        GrpcCallSettings.<AddTrialMeasurementRequest, Trial>newBuilder()
            .setMethodDescriptor(addTrialMeasurementMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<AddTrialMeasurementRequest>() {
                  @Override
                  public Map<String, String> extract(AddTrialMeasurementRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("trial_name", String.valueOf(request.getTrialName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CompleteTrialRequest, Trial> completeTrialTransportSettings =
        GrpcCallSettings.<CompleteTrialRequest, Trial>newBuilder()
            .setMethodDescriptor(completeTrialMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CompleteTrialRequest>() {
                  @Override
                  public Map<String, String> extract(CompleteTrialRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTrialRequest, Empty> deleteTrialTransportSettings =
        GrpcCallSettings.<DeleteTrialRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTrialMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTrialRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTrialRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CheckTrialEarlyStoppingStateRequest, Operation>
        checkTrialEarlyStoppingStateTransportSettings =
            GrpcCallSettings.<CheckTrialEarlyStoppingStateRequest, Operation>newBuilder()
                .setMethodDescriptor(checkTrialEarlyStoppingStateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CheckTrialEarlyStoppingStateRequest>() {
                      @Override
                      public Map<String, String> extract(
                          CheckTrialEarlyStoppingStateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("trial_name", String.valueOf(request.getTrialName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<StopTrialRequest, Trial> stopTrialTransportSettings =
        GrpcCallSettings.<StopTrialRequest, Trial>newBuilder()
            .setMethodDescriptor(stopTrialMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<StopTrialRequest>() {
                  @Override
                  public Map<String, String> extract(StopTrialRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
        listOptimalTrialsTransportSettings =
            GrpcCallSettings.<ListOptimalTrialsRequest, ListOptimalTrialsResponse>newBuilder()
                .setMethodDescriptor(listOptimalTrialsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListOptimalTrialsRequest>() {
                      @Override
                      public Map<String, String> extract(ListOptimalTrialsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.createStudyCallable =
        callableFactory.createUnaryCallable(
            createStudyTransportSettings, settings.createStudySettings(), clientContext);
    this.getStudyCallable =
        callableFactory.createUnaryCallable(
            getStudyTransportSettings, settings.getStudySettings(), clientContext);
    this.listStudiesCallable =
        callableFactory.createUnaryCallable(
            listStudiesTransportSettings, settings.listStudiesSettings(), clientContext);
    this.listStudiesPagedCallable =
        callableFactory.createPagedCallable(
            listStudiesTransportSettings, settings.listStudiesSettings(), clientContext);
    this.deleteStudyCallable =
        callableFactory.createUnaryCallable(
            deleteStudyTransportSettings, settings.deleteStudySettings(), clientContext);
    this.lookupStudyCallable =
        callableFactory.createUnaryCallable(
            lookupStudyTransportSettings, settings.lookupStudySettings(), clientContext);
    this.suggestTrialsCallable =
        callableFactory.createUnaryCallable(
            suggestTrialsTransportSettings, settings.suggestTrialsSettings(), clientContext);
    this.suggestTrialsOperationCallable =
        callableFactory.createOperationCallable(
            suggestTrialsTransportSettings,
            settings.suggestTrialsOperationSettings(),
            clientContext,
            operationsStub);
    this.createTrialCallable =
        callableFactory.createUnaryCallable(
            createTrialTransportSettings, settings.createTrialSettings(), clientContext);
    this.getTrialCallable =
        callableFactory.createUnaryCallable(
            getTrialTransportSettings, settings.getTrialSettings(), clientContext);
    this.listTrialsCallable =
        callableFactory.createUnaryCallable(
            listTrialsTransportSettings, settings.listTrialsSettings(), clientContext);
    this.listTrialsPagedCallable =
        callableFactory.createPagedCallable(
            listTrialsTransportSettings, settings.listTrialsSettings(), clientContext);
    this.addTrialMeasurementCallable =
        callableFactory.createUnaryCallable(
            addTrialMeasurementTransportSettings,
            settings.addTrialMeasurementSettings(),
            clientContext);
    this.completeTrialCallable =
        callableFactory.createUnaryCallable(
            completeTrialTransportSettings, settings.completeTrialSettings(), clientContext);
    this.deleteTrialCallable =
        callableFactory.createUnaryCallable(
            deleteTrialTransportSettings, settings.deleteTrialSettings(), clientContext);
    this.checkTrialEarlyStoppingStateCallable =
        callableFactory.createUnaryCallable(
            checkTrialEarlyStoppingStateTransportSettings,
            settings.checkTrialEarlyStoppingStateSettings(),
            clientContext);
    this.checkTrialEarlyStoppingStateOperationCallable =
        callableFactory.createOperationCallable(
            checkTrialEarlyStoppingStateTransportSettings,
            settings.checkTrialEarlyStoppingStateOperationSettings(),
            clientContext,
            operationsStub);
    this.stopTrialCallable =
        callableFactory.createUnaryCallable(
            stopTrialTransportSettings, settings.stopTrialSettings(), clientContext);
    this.listOptimalTrialsCallable =
        callableFactory.createUnaryCallable(
            listOptimalTrialsTransportSettings,
            settings.listOptimalTrialsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateStudyRequest, Study> createStudyCallable() {
    return createStudyCallable;
  }

  @Override
  public UnaryCallable<GetStudyRequest, Study> getStudyCallable() {
    return getStudyCallable;
  }

  @Override
  public UnaryCallable<ListStudiesRequest, ListStudiesResponse> listStudiesCallable() {
    return listStudiesCallable;
  }

  @Override
  public UnaryCallable<ListStudiesRequest, ListStudiesPagedResponse> listStudiesPagedCallable() {
    return listStudiesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteStudyRequest, Empty> deleteStudyCallable() {
    return deleteStudyCallable;
  }

  @Override
  public UnaryCallable<LookupStudyRequest, Study> lookupStudyCallable() {
    return lookupStudyCallable;
  }

  @Override
  public UnaryCallable<SuggestTrialsRequest, Operation> suggestTrialsCallable() {
    return suggestTrialsCallable;
  }

  @Override
  public OperationCallable<SuggestTrialsRequest, SuggestTrialsResponse, SuggestTrialsMetadata>
      suggestTrialsOperationCallable() {
    return suggestTrialsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateTrialRequest, Trial> createTrialCallable() {
    return createTrialCallable;
  }

  @Override
  public UnaryCallable<GetTrialRequest, Trial> getTrialCallable() {
    return getTrialCallable;
  }

  @Override
  public UnaryCallable<ListTrialsRequest, ListTrialsResponse> listTrialsCallable() {
    return listTrialsCallable;
  }

  @Override
  public UnaryCallable<ListTrialsRequest, ListTrialsPagedResponse> listTrialsPagedCallable() {
    return listTrialsPagedCallable;
  }

  @Override
  public UnaryCallable<AddTrialMeasurementRequest, Trial> addTrialMeasurementCallable() {
    return addTrialMeasurementCallable;
  }

  @Override
  public UnaryCallable<CompleteTrialRequest, Trial> completeTrialCallable() {
    return completeTrialCallable;
  }

  @Override
  public UnaryCallable<DeleteTrialRequest, Empty> deleteTrialCallable() {
    return deleteTrialCallable;
  }

  @Override
  public UnaryCallable<CheckTrialEarlyStoppingStateRequest, Operation>
      checkTrialEarlyStoppingStateCallable() {
    return checkTrialEarlyStoppingStateCallable;
  }

  @Override
  public OperationCallable<
          CheckTrialEarlyStoppingStateRequest,
          CheckTrialEarlyStoppingStateResponse,
          CheckTrialEarlyStoppingStateMetatdata>
      checkTrialEarlyStoppingStateOperationCallable() {
    return checkTrialEarlyStoppingStateOperationCallable;
  }

  @Override
  public UnaryCallable<StopTrialRequest, Trial> stopTrialCallable() {
    return stopTrialCallable;
  }

  @Override
  public UnaryCallable<ListOptimalTrialsRequest, ListOptimalTrialsResponse>
      listOptimalTrialsCallable() {
    return listOptimalTrialsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
