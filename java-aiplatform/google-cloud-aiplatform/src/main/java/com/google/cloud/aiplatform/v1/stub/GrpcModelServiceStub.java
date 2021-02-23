/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.aiplatform.v1.ModelServiceClient.ListModelEvaluationSlicesPagedResponse;
import static com.google.cloud.aiplatform.v1.ModelServiceClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.aiplatform.v1.ModelServiceClient.ListModelsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.DeleteModelRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.ExportModelOperationMetadata;
import com.google.cloud.aiplatform.v1.ExportModelRequest;
import com.google.cloud.aiplatform.v1.ExportModelResponse;
import com.google.cloud.aiplatform.v1.GetModelEvaluationRequest;
import com.google.cloud.aiplatform.v1.GetModelEvaluationSliceRequest;
import com.google.cloud.aiplatform.v1.GetModelRequest;
import com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesRequest;
import com.google.cloud.aiplatform.v1.ListModelEvaluationSlicesResponse;
import com.google.cloud.aiplatform.v1.ListModelEvaluationsRequest;
import com.google.cloud.aiplatform.v1.ListModelEvaluationsResponse;
import com.google.cloud.aiplatform.v1.ListModelsRequest;
import com.google.cloud.aiplatform.v1.ListModelsResponse;
import com.google.cloud.aiplatform.v1.Model;
import com.google.cloud.aiplatform.v1.ModelEvaluation;
import com.google.cloud.aiplatform.v1.ModelEvaluationSlice;
import com.google.cloud.aiplatform.v1.UpdateModelRequest;
import com.google.cloud.aiplatform.v1.UploadModelOperationMetadata;
import com.google.cloud.aiplatform.v1.UploadModelRequest;
import com.google.cloud.aiplatform.v1.UploadModelResponse;
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
 * gRPC stub implementation for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcModelServiceStub extends ModelServiceStub {
  private static final MethodDescriptor<UploadModelRequest, Operation> uploadModelMethodDescriptor =
      MethodDescriptor.<UploadModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ModelService/UploadModel")
          .setRequestMarshaller(ProtoUtils.marshaller(UploadModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetModelRequest, Model> getModelMethodDescriptor =
      MethodDescriptor.<GetModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ModelService/GetModel")
          .setRequestMarshaller(ProtoUtils.marshaller(GetModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ModelService/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateModelRequest, Model> updateModelMethodDescriptor =
      MethodDescriptor.<UpdateModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ModelService/UpdateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteModelRequest, Operation> deleteModelMethodDescriptor =
      MethodDescriptor.<DeleteModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ModelService/DeleteModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExportModelRequest, Operation> exportModelMethodDescriptor =
      MethodDescriptor.<ExportModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1.ModelService/ExportModel")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationMethodDescriptor =
          MethodDescriptor.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ModelService/GetModelEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelEvaluation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsMethodDescriptor =
          MethodDescriptor.<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ModelService/ListModelEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceMethodDescriptor =
          MethodDescriptor.<GetModelEvaluationSliceRequest, ModelEvaluationSlice>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.ModelService/GetModelEvaluationSlice")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelEvaluationSliceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ModelEvaluationSlice.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesMethodDescriptor =
          MethodDescriptor
              .<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.ModelService/ListModelEvaluationSlices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationSlicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelEvaluationSlicesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<UploadModelRequest, Operation> uploadModelCallable;
  private final OperationCallable<
          UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationCallable;
  private final UnaryCallable<GetModelRequest, Model> getModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<UpdateModelRequest, Model> updateModelCallable;
  private final UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable;
  private final OperationCallable<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationCallable;
  private final UnaryCallable<ExportModelRequest, Operation> exportModelCallable;
  private final OperationCallable<
          ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationCallable;
  private final UnaryCallable<GetModelEvaluationRequest, ModelEvaluation>
      getModelEvaluationCallable;
  private final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable;
  private final UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable;
  private final UnaryCallable<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceCallable;
  private final UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesCallable;
  private final UnaryCallable<
          ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcModelServiceStub create(ModelServiceStubSettings settings)
      throws IOException {
    return new GrpcModelServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcModelServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcModelServiceStub(ModelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcModelServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcModelServiceStub(
        ModelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(ModelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcModelServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(
      ModelServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<UploadModelRequest, Operation> uploadModelTransportSettings =
        GrpcCallSettings.<UploadModelRequest, Operation>newBuilder()
            .setMethodDescriptor(uploadModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UploadModelRequest>() {
                  @Override
                  public Map<String, String> extract(UploadModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetModelRequest, Model> getModelTransportSettings =
        GrpcCallSettings.<GetModelRequest, Model>newBuilder()
            .setMethodDescriptor(getModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetModelRequest>() {
                  @Override
                  public Map<String, String> extract(GetModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        GrpcCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListModelsRequest>() {
                  @Override
                  public Map<String, String> extract(ListModelsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateModelRequest, Model> updateModelTransportSettings =
        GrpcCallSettings.<UpdateModelRequest, Model>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateModelRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("model.name", String.valueOf(request.getModel().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteModelRequest, Operation> deleteModelTransportSettings =
        GrpcCallSettings.<DeleteModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteModelRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportModelRequest, Operation> exportModelTransportSettings =
        GrpcCallSettings.<ExportModelRequest, Operation>newBuilder()
            .setMethodDescriptor(exportModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportModelRequest>() {
                  @Override
                  public Map<String, String> extract(ExportModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetModelEvaluationRequest, ModelEvaluation>
        getModelEvaluationTransportSettings =
            GrpcCallSettings.<GetModelEvaluationRequest, ModelEvaluation>newBuilder()
                .setMethodDescriptor(getModelEvaluationMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetModelEvaluationRequest>() {
                      @Override
                      public Map<String, String> extract(GetModelEvaluationRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
        listModelEvaluationsTransportSettings =
            GrpcCallSettings.<ListModelEvaluationsRequest, ListModelEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listModelEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListModelEvaluationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListModelEvaluationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
        getModelEvaluationSliceTransportSettings =
            GrpcCallSettings.<GetModelEvaluationSliceRequest, ModelEvaluationSlice>newBuilder()
                .setMethodDescriptor(getModelEvaluationSliceMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetModelEvaluationSliceRequest>() {
                      @Override
                      public Map<String, String> extract(GetModelEvaluationSliceRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
        listModelEvaluationSlicesTransportSettings =
            GrpcCallSettings
                .<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>newBuilder()
                .setMethodDescriptor(listModelEvaluationSlicesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListModelEvaluationSlicesRequest>() {
                      @Override
                      public Map<String, String> extract(ListModelEvaluationSlicesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.uploadModelCallable =
        callableFactory.createUnaryCallable(
            uploadModelTransportSettings, settings.uploadModelSettings(), clientContext);
    this.uploadModelOperationCallable =
        callableFactory.createOperationCallable(
            uploadModelTransportSettings,
            settings.uploadModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getModelCallable =
        callableFactory.createUnaryCallable(
            getModelTransportSettings, settings.getModelSettings(), clientContext);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.deleteModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelTransportSettings,
            settings.deleteModelOperationSettings(),
            clientContext,
            operationsStub);
    this.exportModelCallable =
        callableFactory.createUnaryCallable(
            exportModelTransportSettings, settings.exportModelSettings(), clientContext);
    this.exportModelOperationCallable =
        callableFactory.createOperationCallable(
            exportModelTransportSettings,
            settings.exportModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            getModelEvaluationTransportSettings,
            settings.getModelEvaluationSettings(),
            clientContext);
    this.listModelEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listModelEvaluationsTransportSettings,
            settings.listModelEvaluationsSettings(),
            clientContext);
    this.listModelEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listModelEvaluationsTransportSettings,
            settings.listModelEvaluationsSettings(),
            clientContext);
    this.getModelEvaluationSliceCallable =
        callableFactory.createUnaryCallable(
            getModelEvaluationSliceTransportSettings,
            settings.getModelEvaluationSliceSettings(),
            clientContext);
    this.listModelEvaluationSlicesCallable =
        callableFactory.createUnaryCallable(
            listModelEvaluationSlicesTransportSettings,
            settings.listModelEvaluationSlicesSettings(),
            clientContext);
    this.listModelEvaluationSlicesPagedCallable =
        callableFactory.createPagedCallable(
            listModelEvaluationSlicesTransportSettings,
            settings.listModelEvaluationSlicesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<UploadModelRequest, Operation> uploadModelCallable() {
    return uploadModelCallable;
  }

  public OperationCallable<UploadModelRequest, UploadModelResponse, UploadModelOperationMetadata>
      uploadModelOperationCallable() {
    return uploadModelOperationCallable;
  }

  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    return getModelCallable;
  }

  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  public UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return updateModelCallable;
  }

  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    return deleteModelCallable;
  }

  public OperationCallable<DeleteModelRequest, Empty, DeleteOperationMetadata>
      deleteModelOperationCallable() {
    return deleteModelOperationCallable;
  }

  public UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    return exportModelCallable;
  }

  public OperationCallable<ExportModelRequest, ExportModelResponse, ExportModelOperationMetadata>
      exportModelOperationCallable() {
    return exportModelOperationCallable;
  }

  public UnaryCallable<GetModelEvaluationRequest, ModelEvaluation> getModelEvaluationCallable() {
    return getModelEvaluationCallable;
  }

  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable() {
    return listModelEvaluationsCallable;
  }

  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable() {
    return listModelEvaluationsPagedCallable;
  }

  public UnaryCallable<GetModelEvaluationSliceRequest, ModelEvaluationSlice>
      getModelEvaluationSliceCallable() {
    return getModelEvaluationSliceCallable;
  }

  public UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesResponse>
      listModelEvaluationSlicesCallable() {
    return listModelEvaluationSlicesCallable;
  }

  public UnaryCallable<ListModelEvaluationSlicesRequest, ListModelEvaluationSlicesPagedResponse>
      listModelEvaluationSlicesPagedCallable() {
    return listModelEvaluationSlicesPagedCallable;
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
