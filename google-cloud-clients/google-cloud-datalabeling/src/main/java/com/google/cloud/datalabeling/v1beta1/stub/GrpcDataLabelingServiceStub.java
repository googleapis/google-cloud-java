/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.datalabeling.v1beta1.stub;

import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotatedDatasetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListInstructionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datalabeling.v1beta1.AnnotatedDataset;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.CreateInstructionMetadata;
import com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.DataItem;
import com.google.cloud.datalabeling.v1beta1.Dataset;
import com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.Example;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ExportDataRequest;
import com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.GetDataItemRequest;
import com.google.cloud.datalabeling.v1beta1.GetDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.GetExampleRequest;
import com.google.cloud.datalabeling.v1beta1.GetInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ImportDataRequest;
import com.google.cloud.datalabeling.v1beta1.Instruction;
import com.google.cloud.datalabeling.v1beta1.LabelAudioRequest;
import com.google.cloud.datalabeling.v1beta1.LabelImageRequest;
import com.google.cloud.datalabeling.v1beta1.LabelOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.LabelTextRequest;
import com.google.cloud.datalabeling.v1beta1.LabelVideoRequest;
import com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse;
import com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse;
import com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest;
import com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse;
import com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse;
import com.google.cloud.datalabeling.v1beta1.ListExamplesRequest;
import com.google.cloud.datalabeling.v1beta1.ListExamplesResponse;
import com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest;
import com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Data Labeling API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcDataLabelingServiceStub extends DataLabelingServiceStub {

  private static final MethodDescriptor<CreateDatasetRequest, Dataset>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteDatasetRequest, Empty> deleteDatasetMethodDescriptor =
      MethodDescriptor.<DeleteDatasetRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/DeleteDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ImportDataRequest, Operation> importDataMethodDescriptor =
      MethodDescriptor.<ImportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/ImportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ExportDataRequest, Operation> exportDataMethodDescriptor =
      MethodDescriptor.<ExportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/ExportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetDataItemRequest, DataItem> getDataItemMethodDescriptor =
      MethodDescriptor.<GetDataItemRequest, DataItem>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/GetDataItem")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDataItemRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DataItem.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListDataItemsRequest, ListDataItemsResponse>
      listDataItemsMethodDescriptor =
          MethodDescriptor.<ListDataItemsRequest, ListDataItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/ListDataItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataItemsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetAnnotatedDatasetRequest, AnnotatedDataset>
      getAnnotatedDatasetMethodDescriptor =
          MethodDescriptor.<GetAnnotatedDatasetRequest, AnnotatedDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/GetAnnotatedDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotatedDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnnotatedDataset.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>
      listAnnotatedDatasetsMethodDescriptor =
          MethodDescriptor.<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/ListAnnotatedDatasets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnnotatedDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnnotatedDatasetsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<LabelImageRequest, Operation> labelImageMethodDescriptor =
      MethodDescriptor.<LabelImageRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/LabelImage")
          .setRequestMarshaller(ProtoUtils.marshaller(LabelImageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<LabelVideoRequest, Operation> labelVideoMethodDescriptor =
      MethodDescriptor.<LabelVideoRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/LabelVideo")
          .setRequestMarshaller(ProtoUtils.marshaller(LabelVideoRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<LabelTextRequest, Operation> labelTextMethodDescriptor =
      MethodDescriptor.<LabelTextRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/LabelText")
          .setRequestMarshaller(ProtoUtils.marshaller(LabelTextRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<LabelAudioRequest, Operation> labelAudioMethodDescriptor =
      MethodDescriptor.<LabelAudioRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/LabelAudio")
          .setRequestMarshaller(ProtoUtils.marshaller(LabelAudioRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetExampleRequest, Example> getExampleMethodDescriptor =
      MethodDescriptor.<GetExampleRequest, Example>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datalabeling.v1beta1.DataLabelingService/GetExample")
          .setRequestMarshaller(ProtoUtils.marshaller(GetExampleRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Example.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListExamplesRequest, ListExamplesResponse>
      listExamplesMethodDescriptor =
          MethodDescriptor.<ListExamplesRequest, ListExamplesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/ListExamples")
              .setRequestMarshaller(ProtoUtils.marshaller(ListExamplesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExamplesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetMethodDescriptor =
          MethodDescriptor.<CreateAnnotationSpecSetRequest, AnnotationSpecSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/CreateAnnotationSpecSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnnotationSpecSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnnotationSpecSet.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetMethodDescriptor =
          MethodDescriptor.<GetAnnotationSpecSetRequest, AnnotationSpecSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/GetAnnotationSpecSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotationSpecSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnnotationSpecSet.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>
      listAnnotationSpecSetsMethodDescriptor =
          MethodDescriptor
              .<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/ListAnnotationSpecSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnnotationSpecSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnnotationSpecSetsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteAnnotationSpecSetRequest, Empty>
      deleteAnnotationSpecSetMethodDescriptor =
          MethodDescriptor.<DeleteAnnotationSpecSetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/DeleteAnnotationSpecSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnnotationSpecSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateInstructionRequest, Operation>
      createInstructionMethodDescriptor =
          MethodDescriptor.<CreateInstructionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/CreateInstruction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstructionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetInstructionRequest, Instruction>
      getInstructionMethodDescriptor =
          MethodDescriptor.<GetInstructionRequest, Instruction>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/GetInstruction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInstructionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Instruction.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListInstructionsRequest, ListInstructionsResponse>
      listInstructionsMethodDescriptor =
          MethodDescriptor.<ListInstructionsRequest, ListInstructionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/ListInstructions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstructionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstructionsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteInstructionRequest, Empty>
      deleteInstructionMethodDescriptor =
          MethodDescriptor.<DeleteInstructionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/DeleteInstruction")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstructionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteAnnotatedDatasetRequest, Empty>
      deleteAnnotatedDatasetMethodDescriptor =
          MethodDescriptor.<DeleteAnnotatedDatasetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.datalabeling.v1beta1.DataLabelingService/DeleteAnnotatedDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnnotatedDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable;
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<
          ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<
          ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<GetDataItemRequest, DataItem> getDataItemCallable;
  private final UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable;
  private final UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable;
  private final UnaryCallable<GetAnnotatedDatasetRequest, AnnotatedDataset>
      getAnnotatedDatasetCallable;
  private final UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>
      listAnnotatedDatasetsCallable;
  private final UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsPagedResponse>
      listAnnotatedDatasetsPagedCallable;
  private final UnaryCallable<LabelImageRequest, Operation> labelImageCallable;
  private final OperationCallable<LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
      labelImageOperationCallable;
  private final UnaryCallable<LabelVideoRequest, Operation> labelVideoCallable;
  private final OperationCallable<LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
      labelVideoOperationCallable;
  private final UnaryCallable<LabelTextRequest, Operation> labelTextCallable;
  private final OperationCallable<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
      labelTextOperationCallable;
  private final UnaryCallable<LabelAudioRequest, Operation> labelAudioCallable;
  private final OperationCallable<LabelAudioRequest, AnnotatedDataset, LabelOperationMetadata>
      labelAudioOperationCallable;
  private final UnaryCallable<GetExampleRequest, Example> getExampleCallable;
  private final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable;
  private final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable;
  private final UnaryCallable<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetCallable;
  private final UnaryCallable<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetCallable;
  private final UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>
      listAnnotationSpecSetsCallable;
  private final UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsPagedResponse>
      listAnnotationSpecSetsPagedCallable;
  private final UnaryCallable<DeleteAnnotationSpecSetRequest, Empty>
      deleteAnnotationSpecSetCallable;
  private final UnaryCallable<CreateInstructionRequest, Operation> createInstructionCallable;
  private final OperationCallable<CreateInstructionRequest, Instruction, CreateInstructionMetadata>
      createInstructionOperationCallable;
  private final UnaryCallable<GetInstructionRequest, Instruction> getInstructionCallable;
  private final UnaryCallable<ListInstructionsRequest, ListInstructionsResponse>
      listInstructionsCallable;
  private final UnaryCallable<ListInstructionsRequest, ListInstructionsPagedResponse>
      listInstructionsPagedCallable;
  private final UnaryCallable<DeleteInstructionRequest, Empty> deleteInstructionCallable;
  private final UnaryCallable<DeleteAnnotatedDatasetRequest, Empty> deleteAnnotatedDatasetCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataLabelingServiceStub create(DataLabelingServiceStubSettings settings)
      throws IOException {
    return new GrpcDataLabelingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataLabelingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataLabelingServiceStub(
        DataLabelingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataLabelingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataLabelingServiceStub(
        DataLabelingServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataLabelingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataLabelingServiceStub(
      DataLabelingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataLabelingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataLabelingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataLabelingServiceStub(
      DataLabelingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDatasetRequest, Dataset> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(CreateDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(GetDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDatasetsRequest>() {
                  @Override
                  public Map<String, String> extract(ListDatasetsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Empty> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        GrpcCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ImportDataRequest>() {
                  @Override
                  public Map<String, String> extract(ImportDataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        GrpcCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportDataRequest>() {
                  @Override
                  public Map<String, String> extract(ExportDataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDataItemRequest, DataItem> getDataItemTransportSettings =
        GrpcCallSettings.<GetDataItemRequest, DataItem>newBuilder()
            .setMethodDescriptor(getDataItemMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDataItemRequest>() {
                  @Override
                  public Map<String, String> extract(GetDataItemRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDataItemsRequest, ListDataItemsResponse> listDataItemsTransportSettings =
        GrpcCallSettings.<ListDataItemsRequest, ListDataItemsResponse>newBuilder()
            .setMethodDescriptor(listDataItemsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDataItemsRequest>() {
                  @Override
                  public Map<String, String> extract(ListDataItemsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetAnnotatedDatasetRequest, AnnotatedDataset>
        getAnnotatedDatasetTransportSettings =
            GrpcCallSettings.<GetAnnotatedDatasetRequest, AnnotatedDataset>newBuilder()
                .setMethodDescriptor(getAnnotatedDatasetMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetAnnotatedDatasetRequest>() {
                      @Override
                      public Map<String, String> extract(GetAnnotatedDatasetRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>
        listAnnotatedDatasetsTransportSettings =
            GrpcCallSettings
                .<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>newBuilder()
                .setMethodDescriptor(listAnnotatedDatasetsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListAnnotatedDatasetsRequest>() {
                      @Override
                      public Map<String, String> extract(ListAnnotatedDatasetsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<LabelImageRequest, Operation> labelImageTransportSettings =
        GrpcCallSettings.<LabelImageRequest, Operation>newBuilder()
            .setMethodDescriptor(labelImageMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<LabelImageRequest>() {
                  @Override
                  public Map<String, String> extract(LabelImageRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<LabelVideoRequest, Operation> labelVideoTransportSettings =
        GrpcCallSettings.<LabelVideoRequest, Operation>newBuilder()
            .setMethodDescriptor(labelVideoMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<LabelVideoRequest>() {
                  @Override
                  public Map<String, String> extract(LabelVideoRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<LabelTextRequest, Operation> labelTextTransportSettings =
        GrpcCallSettings.<LabelTextRequest, Operation>newBuilder()
            .setMethodDescriptor(labelTextMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<LabelTextRequest>() {
                  @Override
                  public Map<String, String> extract(LabelTextRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<LabelAudioRequest, Operation> labelAudioTransportSettings =
        GrpcCallSettings.<LabelAudioRequest, Operation>newBuilder()
            .setMethodDescriptor(labelAudioMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<LabelAudioRequest>() {
                  @Override
                  public Map<String, String> extract(LabelAudioRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetExampleRequest, Example> getExampleTransportSettings =
        GrpcCallSettings.<GetExampleRequest, Example>newBuilder()
            .setMethodDescriptor(getExampleMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetExampleRequest>() {
                  @Override
                  public Map<String, String> extract(GetExampleRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListExamplesRequest, ListExamplesResponse> listExamplesTransportSettings =
        GrpcCallSettings.<ListExamplesRequest, ListExamplesResponse>newBuilder()
            .setMethodDescriptor(listExamplesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListExamplesRequest>() {
                  @Override
                  public Map<String, String> extract(ListExamplesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
        createAnnotationSpecSetTransportSettings =
            GrpcCallSettings.<CreateAnnotationSpecSetRequest, AnnotationSpecSet>newBuilder()
                .setMethodDescriptor(createAnnotationSpecSetMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateAnnotationSpecSetRequest>() {
                      @Override
                      public Map<String, String> extract(CreateAnnotationSpecSetRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetAnnotationSpecSetRequest, AnnotationSpecSet>
        getAnnotationSpecSetTransportSettings =
            GrpcCallSettings.<GetAnnotationSpecSetRequest, AnnotationSpecSet>newBuilder()
                .setMethodDescriptor(getAnnotationSpecSetMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetAnnotationSpecSetRequest>() {
                      @Override
                      public Map<String, String> extract(GetAnnotationSpecSetRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>
        listAnnotationSpecSetsTransportSettings =
            GrpcCallSettings
                .<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>newBuilder()
                .setMethodDescriptor(listAnnotationSpecSetsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListAnnotationSpecSetsRequest>() {
                      @Override
                      public Map<String, String> extract(ListAnnotationSpecSetsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteAnnotationSpecSetRequest, Empty>
        deleteAnnotationSpecSetTransportSettings =
            GrpcCallSettings.<DeleteAnnotationSpecSetRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAnnotationSpecSetMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteAnnotationSpecSetRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteAnnotationSpecSetRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateInstructionRequest, Operation> createInstructionTransportSettings =
        GrpcCallSettings.<CreateInstructionRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstructionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateInstructionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateInstructionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetInstructionRequest, Instruction> getInstructionTransportSettings =
        GrpcCallSettings.<GetInstructionRequest, Instruction>newBuilder()
            .setMethodDescriptor(getInstructionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetInstructionRequest>() {
                  @Override
                  public Map<String, String> extract(GetInstructionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListInstructionsRequest, ListInstructionsResponse>
        listInstructionsTransportSettings =
            GrpcCallSettings.<ListInstructionsRequest, ListInstructionsResponse>newBuilder()
                .setMethodDescriptor(listInstructionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListInstructionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListInstructionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteInstructionRequest, Empty> deleteInstructionTransportSettings =
        GrpcCallSettings.<DeleteInstructionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteInstructionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteInstructionRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteInstructionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteAnnotatedDatasetRequest, Empty> deleteAnnotatedDatasetTransportSettings =
        GrpcCallSettings.<DeleteAnnotatedDatasetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnnotatedDatasetMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteAnnotatedDatasetRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteAnnotatedDatasetRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            this.operationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            this.operationsStub);
    this.getDataItemCallable =
        callableFactory.createUnaryCallable(
            getDataItemTransportSettings, settings.getDataItemSettings(), clientContext);
    this.listDataItemsCallable =
        callableFactory.createUnaryCallable(
            listDataItemsTransportSettings, settings.listDataItemsSettings(), clientContext);
    this.listDataItemsPagedCallable =
        callableFactory.createPagedCallable(
            listDataItemsTransportSettings, settings.listDataItemsSettings(), clientContext);
    this.getAnnotatedDatasetCallable =
        callableFactory.createUnaryCallable(
            getAnnotatedDatasetTransportSettings,
            settings.getAnnotatedDatasetSettings(),
            clientContext);
    this.listAnnotatedDatasetsCallable =
        callableFactory.createUnaryCallable(
            listAnnotatedDatasetsTransportSettings,
            settings.listAnnotatedDatasetsSettings(),
            clientContext);
    this.listAnnotatedDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listAnnotatedDatasetsTransportSettings,
            settings.listAnnotatedDatasetsSettings(),
            clientContext);
    this.labelImageCallable =
        callableFactory.createUnaryCallable(
            labelImageTransportSettings, settings.labelImageSettings(), clientContext);
    this.labelImageOperationCallable =
        callableFactory.createOperationCallable(
            labelImageTransportSettings,
            settings.labelImageOperationSettings(),
            clientContext,
            this.operationsStub);
    this.labelVideoCallable =
        callableFactory.createUnaryCallable(
            labelVideoTransportSettings, settings.labelVideoSettings(), clientContext);
    this.labelVideoOperationCallable =
        callableFactory.createOperationCallable(
            labelVideoTransportSettings,
            settings.labelVideoOperationSettings(),
            clientContext,
            this.operationsStub);
    this.labelTextCallable =
        callableFactory.createUnaryCallable(
            labelTextTransportSettings, settings.labelTextSettings(), clientContext);
    this.labelTextOperationCallable =
        callableFactory.createOperationCallable(
            labelTextTransportSettings,
            settings.labelTextOperationSettings(),
            clientContext,
            this.operationsStub);
    this.labelAudioCallable =
        callableFactory.createUnaryCallable(
            labelAudioTransportSettings, settings.labelAudioSettings(), clientContext);
    this.labelAudioOperationCallable =
        callableFactory.createOperationCallable(
            labelAudioTransportSettings,
            settings.labelAudioOperationSettings(),
            clientContext,
            this.operationsStub);
    this.getExampleCallable =
        callableFactory.createUnaryCallable(
            getExampleTransportSettings, settings.getExampleSettings(), clientContext);
    this.listExamplesCallable =
        callableFactory.createUnaryCallable(
            listExamplesTransportSettings, settings.listExamplesSettings(), clientContext);
    this.listExamplesPagedCallable =
        callableFactory.createPagedCallable(
            listExamplesTransportSettings, settings.listExamplesSettings(), clientContext);
    this.createAnnotationSpecSetCallable =
        callableFactory.createUnaryCallable(
            createAnnotationSpecSetTransportSettings,
            settings.createAnnotationSpecSetSettings(),
            clientContext);
    this.getAnnotationSpecSetCallable =
        callableFactory.createUnaryCallable(
            getAnnotationSpecSetTransportSettings,
            settings.getAnnotationSpecSetSettings(),
            clientContext);
    this.listAnnotationSpecSetsCallable =
        callableFactory.createUnaryCallable(
            listAnnotationSpecSetsTransportSettings,
            settings.listAnnotationSpecSetsSettings(),
            clientContext);
    this.listAnnotationSpecSetsPagedCallable =
        callableFactory.createPagedCallable(
            listAnnotationSpecSetsTransportSettings,
            settings.listAnnotationSpecSetsSettings(),
            clientContext);
    this.deleteAnnotationSpecSetCallable =
        callableFactory.createUnaryCallable(
            deleteAnnotationSpecSetTransportSettings,
            settings.deleteAnnotationSpecSetSettings(),
            clientContext);
    this.createInstructionCallable =
        callableFactory.createUnaryCallable(
            createInstructionTransportSettings,
            settings.createInstructionSettings(),
            clientContext);
    this.createInstructionOperationCallable =
        callableFactory.createOperationCallable(
            createInstructionTransportSettings,
            settings.createInstructionOperationSettings(),
            clientContext,
            this.operationsStub);
    this.getInstructionCallable =
        callableFactory.createUnaryCallable(
            getInstructionTransportSettings, settings.getInstructionSettings(), clientContext);
    this.listInstructionsCallable =
        callableFactory.createUnaryCallable(
            listInstructionsTransportSettings, settings.listInstructionsSettings(), clientContext);
    this.listInstructionsPagedCallable =
        callableFactory.createPagedCallable(
            listInstructionsTransportSettings, settings.listInstructionsSettings(), clientContext);
    this.deleteInstructionCallable =
        callableFactory.createUnaryCallable(
            deleteInstructionTransportSettings,
            settings.deleteInstructionSettings(),
            clientContext);
    this.deleteAnnotatedDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteAnnotatedDatasetTransportSettings,
            settings.deleteAnnotatedDatasetSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return createDatasetCallable;
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  public UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  public UnaryCallable<GetDataItemRequest, DataItem> getDataItemCallable() {
    return getDataItemCallable;
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    return listDataItemsPagedCallable;
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    return listDataItemsCallable;
  }

  public UnaryCallable<GetAnnotatedDatasetRequest, AnnotatedDataset> getAnnotatedDatasetCallable() {
    return getAnnotatedDatasetCallable;
  }

  public UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsPagedResponse>
      listAnnotatedDatasetsPagedCallable() {
    return listAnnotatedDatasetsPagedCallable;
  }

  public UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse>
      listAnnotatedDatasetsCallable() {
    return listAnnotatedDatasetsCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
      labelImageOperationCallable() {
    return labelImageOperationCallable;
  }

  public UnaryCallable<LabelImageRequest, Operation> labelImageCallable() {
    return labelImageCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
      labelVideoOperationCallable() {
    return labelVideoOperationCallable;
  }

  public UnaryCallable<LabelVideoRequest, Operation> labelVideoCallable() {
    return labelVideoCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
      labelTextOperationCallable() {
    return labelTextOperationCallable;
  }

  public UnaryCallable<LabelTextRequest, Operation> labelTextCallable() {
    return labelTextCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<LabelAudioRequest, AnnotatedDataset, LabelOperationMetadata>
      labelAudioOperationCallable() {
    return labelAudioOperationCallable;
  }

  public UnaryCallable<LabelAudioRequest, Operation> labelAudioCallable() {
    return labelAudioCallable;
  }

  public UnaryCallable<GetExampleRequest, Example> getExampleCallable() {
    return getExampleCallable;
  }

  public UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse> listExamplesPagedCallable() {
    return listExamplesPagedCallable;
  }

  public UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return listExamplesCallable;
  }

  public UnaryCallable<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetCallable() {
    return createAnnotationSpecSetCallable;
  }

  public UnaryCallable<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetCallable() {
    return getAnnotationSpecSetCallable;
  }

  public UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsPagedResponse>
      listAnnotationSpecSetsPagedCallable() {
    return listAnnotationSpecSetsPagedCallable;
  }

  public UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>
      listAnnotationSpecSetsCallable() {
    return listAnnotationSpecSetsCallable;
  }

  public UnaryCallable<DeleteAnnotationSpecSetRequest, Empty> deleteAnnotationSpecSetCallable() {
    return deleteAnnotationSpecSetCallable;
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateInstructionRequest, Instruction, CreateInstructionMetadata>
      createInstructionOperationCallable() {
    return createInstructionOperationCallable;
  }

  public UnaryCallable<CreateInstructionRequest, Operation> createInstructionCallable() {
    return createInstructionCallable;
  }

  public UnaryCallable<GetInstructionRequest, Instruction> getInstructionCallable() {
    return getInstructionCallable;
  }

  public UnaryCallable<ListInstructionsRequest, ListInstructionsPagedResponse>
      listInstructionsPagedCallable() {
    return listInstructionsPagedCallable;
  }

  public UnaryCallable<ListInstructionsRequest, ListInstructionsResponse>
      listInstructionsCallable() {
    return listInstructionsCallable;
  }

  public UnaryCallable<DeleteInstructionRequest, Empty> deleteInstructionCallable() {
    return deleteInstructionCallable;
  }

  public UnaryCallable<DeleteAnnotatedDatasetRequest, Empty> deleteAnnotatedDatasetCallable() {
    return deleteAnnotatedDatasetCallable;
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
