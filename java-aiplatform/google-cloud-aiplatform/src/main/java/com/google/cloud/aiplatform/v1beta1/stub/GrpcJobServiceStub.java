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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListBatchPredictionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListCustomJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListDataLabelingJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListHyperparameterTuningJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1beta1.CancelBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1beta1.CancelCustomJobRequest;
import com.google.cloud.aiplatform.v1beta1.CancelDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1beta1.CancelHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1beta1.CreateBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1beta1.CreateCustomJobRequest;
import com.google.cloud.aiplatform.v1beta1.CreateDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1beta1.CreateHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1beta1.CustomJob;
import com.google.cloud.aiplatform.v1beta1.DataLabelingJob;
import com.google.cloud.aiplatform.v1beta1.DeleteBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteCustomJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1beta1.GetCustomJobRequest;
import com.google.cloud.aiplatform.v1beta1.GetDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1beta1.GetHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1beta1.HyperparameterTuningJob;
import com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListBatchPredictionJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListCustomJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListCustomJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDataLabelingJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListHyperparameterTuningJobsResponse;
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
 * gRPC stub implementation for the JobService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcJobServiceStub extends JobServiceStub {
  private static final MethodDescriptor<CreateCustomJobRequest, CustomJob>
      createCustomJobMethodDescriptor =
          MethodDescriptor.<CreateCustomJobRequest, CustomJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/CreateCustomJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomJobRequest, CustomJob>
      getCustomJobMethodDescriptor =
          MethodDescriptor.<GetCustomJobRequest, CustomJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/GetCustomJob")
              .setRequestMarshaller(ProtoUtils.marshaller(GetCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomJobsRequest, ListCustomJobsResponse>
      listCustomJobsMethodDescriptor =
          MethodDescriptor.<ListCustomJobsRequest, ListCustomJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/ListCustomJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomJobRequest, Operation>
      deleteCustomJobMethodDescriptor =
          MethodDescriptor.<DeleteCustomJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/DeleteCustomJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelCustomJobRequest, Empty>
      cancelCustomJobMethodDescriptor =
          MethodDescriptor.<CancelCustomJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/CancelCustomJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobMethodDescriptor =
          MethodDescriptor.<CreateDataLabelingJobRequest, DataLabelingJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/CreateDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataLabelingJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobMethodDescriptor =
          MethodDescriptor.<GetDataLabelingJobRequest, DataLabelingJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/GetDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataLabelingJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsMethodDescriptor =
          MethodDescriptor.<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/ListDataLabelingJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataLabelingJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataLabelingJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobMethodDescriptor =
          MethodDescriptor.<DeleteDataLabelingJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/DeleteDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelDataLabelingJobRequest, Empty>
      cancelDataLabelingJobMethodDescriptor =
          MethodDescriptor.<CancelDataLabelingJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/CancelDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor
              .<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/CreateHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HyperparameterTuningJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor.<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/GetHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HyperparameterTuningJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsMethodDescriptor =
          MethodDescriptor
              .<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/ListHyperparameterTuningJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHyperparameterTuningJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHyperparameterTuningJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor.<DeleteHyperparameterTuningJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/DeleteHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor.<CancelHyperparameterTuningJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/CancelHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<CreateBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/CreateBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BatchPredictionJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<GetBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.JobService/GetBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BatchPredictionJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsMethodDescriptor =
          MethodDescriptor
              .<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/ListBatchPredictionJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBatchPredictionJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBatchPredictionJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<DeleteBatchPredictionJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/DeleteBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<CancelBatchPredictionJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.JobService/CancelBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateCustomJobRequest, CustomJob> createCustomJobCallable;
  private final UnaryCallable<GetCustomJobRequest, CustomJob> getCustomJobCallable;
  private final UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse> listCustomJobsCallable;
  private final UnaryCallable<ListCustomJobsRequest, ListCustomJobsPagedResponse>
      listCustomJobsPagedCallable;
  private final UnaryCallable<DeleteCustomJobRequest, Operation> deleteCustomJobCallable;
  private final OperationCallable<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationCallable;
  private final UnaryCallable<CancelCustomJobRequest, Empty> cancelCustomJobCallable;
  private final UnaryCallable<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobCallable;
  private final UnaryCallable<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobCallable;
  private final UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsCallable;
  private final UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsPagedCallable;
  private final UnaryCallable<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobCallable;
  private final OperationCallable<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationCallable;
  private final UnaryCallable<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobCallable;
  private final UnaryCallable<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobCallable;
  private final UnaryCallable<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobCallable;
  private final UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsCallable;
  private final UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsPagedCallable;
  private final UnaryCallable<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobCallable;
  private final OperationCallable<
          DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationCallable;
  private final UnaryCallable<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobCallable;
  private final UnaryCallable<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobCallable;
  private final UnaryCallable<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobCallable;
  private final UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsCallable;
  private final UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsPagedCallable;
  private final UnaryCallable<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobCallable;
  private final OperationCallable<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationCallable;
  private final UnaryCallable<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcJobServiceStub create(JobServiceStubSettings settings)
      throws IOException {
    return new GrpcJobServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcJobServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcJobServiceStub(JobServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcJobServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcJobServiceStub(
        JobServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcJobServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobServiceStub(JobServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcJobServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcJobServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobServiceStub(
      JobServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCustomJobRequest, CustomJob> createCustomJobTransportSettings =
        GrpcCallSettings.<CreateCustomJobRequest, CustomJob>newBuilder()
            .setMethodDescriptor(createCustomJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateCustomJobRequest>() {
                  @Override
                  public Map<String, String> extract(CreateCustomJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetCustomJobRequest, CustomJob> getCustomJobTransportSettings =
        GrpcCallSettings.<GetCustomJobRequest, CustomJob>newBuilder()
            .setMethodDescriptor(getCustomJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetCustomJobRequest>() {
                  @Override
                  public Map<String, String> extract(GetCustomJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListCustomJobsRequest, ListCustomJobsResponse>
        listCustomJobsTransportSettings =
            GrpcCallSettings.<ListCustomJobsRequest, ListCustomJobsResponse>newBuilder()
                .setMethodDescriptor(listCustomJobsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListCustomJobsRequest>() {
                      @Override
                      public Map<String, String> extract(ListCustomJobsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteCustomJobRequest, Operation> deleteCustomJobTransportSettings =
        GrpcCallSettings.<DeleteCustomJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCustomJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteCustomJobRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteCustomJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CancelCustomJobRequest, Empty> cancelCustomJobTransportSettings =
        GrpcCallSettings.<CancelCustomJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelCustomJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelCustomJobRequest>() {
                  @Override
                  public Map<String, String> extract(CancelCustomJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateDataLabelingJobRequest, DataLabelingJob>
        createDataLabelingJobTransportSettings =
            GrpcCallSettings.<CreateDataLabelingJobRequest, DataLabelingJob>newBuilder()
                .setMethodDescriptor(createDataLabelingJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateDataLabelingJobRequest>() {
                      @Override
                      public Map<String, String> extract(CreateDataLabelingJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetDataLabelingJobRequest, DataLabelingJob>
        getDataLabelingJobTransportSettings =
            GrpcCallSettings.<GetDataLabelingJobRequest, DataLabelingJob>newBuilder()
                .setMethodDescriptor(getDataLabelingJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetDataLabelingJobRequest>() {
                      @Override
                      public Map<String, String> extract(GetDataLabelingJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
        listDataLabelingJobsTransportSettings =
            GrpcCallSettings.<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>newBuilder()
                .setMethodDescriptor(listDataLabelingJobsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListDataLabelingJobsRequest>() {
                      @Override
                      public Map<String, String> extract(ListDataLabelingJobsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteDataLabelingJobRequest, Operation>
        deleteDataLabelingJobTransportSettings =
            GrpcCallSettings.<DeleteDataLabelingJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDataLabelingJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteDataLabelingJobRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteDataLabelingJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobTransportSettings =
        GrpcCallSettings.<CancelDataLabelingJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDataLabelingJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelDataLabelingJobRequest>() {
                  @Override
                  public Map<String, String> extract(CancelDataLabelingJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
        createHyperparameterTuningJobTransportSettings =
            GrpcCallSettings
                .<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
                .setMethodDescriptor(createHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateHyperparameterTuningJobRequest>() {
                      @Override
                      public Map<String, String> extract(
                          CreateHyperparameterTuningJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
        getHyperparameterTuningJobTransportSettings =
            GrpcCallSettings
                .<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
                .setMethodDescriptor(getHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetHyperparameterTuningJobRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GetHyperparameterTuningJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
        listHyperparameterTuningJobsTransportSettings =
            GrpcCallSettings
                .<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listHyperparameterTuningJobsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListHyperparameterTuningJobsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          ListHyperparameterTuningJobsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteHyperparameterTuningJobRequest, Operation>
        deleteHyperparameterTuningJobTransportSettings =
            GrpcCallSettings.<DeleteHyperparameterTuningJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteHyperparameterTuningJobRequest>() {
                      @Override
                      public Map<String, String> extract(
                          DeleteHyperparameterTuningJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CancelHyperparameterTuningJobRequest, Empty>
        cancelHyperparameterTuningJobTransportSettings =
            GrpcCallSettings.<CancelHyperparameterTuningJobRequest, Empty>newBuilder()
                .setMethodDescriptor(cancelHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CancelHyperparameterTuningJobRequest>() {
                      @Override
                      public Map<String, String> extract(
                          CancelHyperparameterTuningJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateBatchPredictionJobRequest, BatchPredictionJob>
        createBatchPredictionJobTransportSettings =
            GrpcCallSettings.<CreateBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
                .setMethodDescriptor(createBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateBatchPredictionJobRequest>() {
                      @Override
                      public Map<String, String> extract(CreateBatchPredictionJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetBatchPredictionJobRequest, BatchPredictionJob>
        getBatchPredictionJobTransportSettings =
            GrpcCallSettings.<GetBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
                .setMethodDescriptor(getBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetBatchPredictionJobRequest>() {
                      @Override
                      public Map<String, String> extract(GetBatchPredictionJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
        listBatchPredictionJobsTransportSettings =
            GrpcCallSettings
                .<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>newBuilder()
                .setMethodDescriptor(listBatchPredictionJobsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListBatchPredictionJobsRequest>() {
                      @Override
                      public Map<String, String> extract(ListBatchPredictionJobsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteBatchPredictionJobRequest, Operation>
        deleteBatchPredictionJobTransportSettings =
            GrpcCallSettings.<DeleteBatchPredictionJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteBatchPredictionJobRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteBatchPredictionJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CancelBatchPredictionJobRequest, Empty>
        cancelBatchPredictionJobTransportSettings =
            GrpcCallSettings.<CancelBatchPredictionJobRequest, Empty>newBuilder()
                .setMethodDescriptor(cancelBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CancelBatchPredictionJobRequest>() {
                      @Override
                      public Map<String, String> extract(CancelBatchPredictionJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

    this.createCustomJobCallable =
        callableFactory.createUnaryCallable(
            createCustomJobTransportSettings, settings.createCustomJobSettings(), clientContext);
    this.getCustomJobCallable =
        callableFactory.createUnaryCallable(
            getCustomJobTransportSettings, settings.getCustomJobSettings(), clientContext);
    this.listCustomJobsCallable =
        callableFactory.createUnaryCallable(
            listCustomJobsTransportSettings, settings.listCustomJobsSettings(), clientContext);
    this.listCustomJobsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomJobsTransportSettings, settings.listCustomJobsSettings(), clientContext);
    this.deleteCustomJobCallable =
        callableFactory.createUnaryCallable(
            deleteCustomJobTransportSettings, settings.deleteCustomJobSettings(), clientContext);
    this.deleteCustomJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteCustomJobTransportSettings,
            settings.deleteCustomJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelCustomJobCallable =
        callableFactory.createUnaryCallable(
            cancelCustomJobTransportSettings, settings.cancelCustomJobSettings(), clientContext);
    this.createDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            createDataLabelingJobTransportSettings,
            settings.createDataLabelingJobSettings(),
            clientContext);
    this.getDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            getDataLabelingJobTransportSettings,
            settings.getDataLabelingJobSettings(),
            clientContext);
    this.listDataLabelingJobsCallable =
        callableFactory.createUnaryCallable(
            listDataLabelingJobsTransportSettings,
            settings.listDataLabelingJobsSettings(),
            clientContext);
    this.listDataLabelingJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDataLabelingJobsTransportSettings,
            settings.listDataLabelingJobsSettings(),
            clientContext);
    this.deleteDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            deleteDataLabelingJobTransportSettings,
            settings.deleteDataLabelingJobSettings(),
            clientContext);
    this.deleteDataLabelingJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataLabelingJobTransportSettings,
            settings.deleteDataLabelingJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            cancelDataLabelingJobTransportSettings,
            settings.cancelDataLabelingJobSettings(),
            clientContext);
    this.createHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            createHyperparameterTuningJobTransportSettings,
            settings.createHyperparameterTuningJobSettings(),
            clientContext);
    this.getHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            getHyperparameterTuningJobTransportSettings,
            settings.getHyperparameterTuningJobSettings(),
            clientContext);
    this.listHyperparameterTuningJobsCallable =
        callableFactory.createUnaryCallable(
            listHyperparameterTuningJobsTransportSettings,
            settings.listHyperparameterTuningJobsSettings(),
            clientContext);
    this.listHyperparameterTuningJobsPagedCallable =
        callableFactory.createPagedCallable(
            listHyperparameterTuningJobsTransportSettings,
            settings.listHyperparameterTuningJobsSettings(),
            clientContext);
    this.deleteHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            deleteHyperparameterTuningJobTransportSettings,
            settings.deleteHyperparameterTuningJobSettings(),
            clientContext);
    this.deleteHyperparameterTuningJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteHyperparameterTuningJobTransportSettings,
            settings.deleteHyperparameterTuningJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            cancelHyperparameterTuningJobTransportSettings,
            settings.cancelHyperparameterTuningJobSettings(),
            clientContext);
    this.createBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            createBatchPredictionJobTransportSettings,
            settings.createBatchPredictionJobSettings(),
            clientContext);
    this.getBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            getBatchPredictionJobTransportSettings,
            settings.getBatchPredictionJobSettings(),
            clientContext);
    this.listBatchPredictionJobsCallable =
        callableFactory.createUnaryCallable(
            listBatchPredictionJobsTransportSettings,
            settings.listBatchPredictionJobsSettings(),
            clientContext);
    this.listBatchPredictionJobsPagedCallable =
        callableFactory.createPagedCallable(
            listBatchPredictionJobsTransportSettings,
            settings.listBatchPredictionJobsSettings(),
            clientContext);
    this.deleteBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            deleteBatchPredictionJobTransportSettings,
            settings.deleteBatchPredictionJobSettings(),
            clientContext);
    this.deleteBatchPredictionJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteBatchPredictionJobTransportSettings,
            settings.deleteBatchPredictionJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            cancelBatchPredictionJobTransportSettings,
            settings.cancelBatchPredictionJobSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateCustomJobRequest, CustomJob> createCustomJobCallable() {
    return createCustomJobCallable;
  }

  @Override
  public UnaryCallable<GetCustomJobRequest, CustomJob> getCustomJobCallable() {
    return getCustomJobCallable;
  }

  @Override
  public UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse> listCustomJobsCallable() {
    return listCustomJobsCallable;
  }

  @Override
  public UnaryCallable<ListCustomJobsRequest, ListCustomJobsPagedResponse>
      listCustomJobsPagedCallable() {
    return listCustomJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomJobRequest, Operation> deleteCustomJobCallable() {
    return deleteCustomJobCallable;
  }

  @Override
  public OperationCallable<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationCallable() {
    return deleteCustomJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelCustomJobRequest, Empty> cancelCustomJobCallable() {
    return cancelCustomJobCallable;
  }

  @Override
  public UnaryCallable<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobCallable() {
    return createDataLabelingJobCallable;
  }

  @Override
  public UnaryCallable<GetDataLabelingJobRequest, DataLabelingJob> getDataLabelingJobCallable() {
    return getDataLabelingJobCallable;
  }

  @Override
  public UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsCallable() {
    return listDataLabelingJobsCallable;
  }

  @Override
  public UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsPagedCallable() {
    return listDataLabelingJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDataLabelingJobRequest, Operation> deleteDataLabelingJobCallable() {
    return deleteDataLabelingJobCallable;
  }

  @Override
  public OperationCallable<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationCallable() {
    return deleteDataLabelingJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobCallable() {
    return cancelDataLabelingJobCallable;
  }

  @Override
  public UnaryCallable<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobCallable() {
    return createHyperparameterTuningJobCallable;
  }

  @Override
  public UnaryCallable<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobCallable() {
    return getHyperparameterTuningJobCallable;
  }

  @Override
  public UnaryCallable<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsCallable() {
    return listHyperparameterTuningJobsCallable;
  }

  @Override
  public UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsPagedCallable() {
    return listHyperparameterTuningJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobCallable() {
    return deleteHyperparameterTuningJobCallable;
  }

  @Override
  public OperationCallable<DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationCallable() {
    return deleteHyperparameterTuningJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobCallable() {
    return cancelHyperparameterTuningJobCallable;
  }

  @Override
  public UnaryCallable<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobCallable() {
    return createBatchPredictionJobCallable;
  }

  @Override
  public UnaryCallable<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobCallable() {
    return getBatchPredictionJobCallable;
  }

  @Override
  public UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsCallable() {
    return listBatchPredictionJobsCallable;
  }

  @Override
  public UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsPagedCallable() {
    return listBatchPredictionJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobCallable() {
    return deleteBatchPredictionJobCallable;
  }

  @Override
  public OperationCallable<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationCallable() {
    return deleteBatchPredictionJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelBatchPredictionJobRequest, Empty> cancelBatchPredictionJobCallable() {
    return cancelBatchPredictionJobCallable;
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
