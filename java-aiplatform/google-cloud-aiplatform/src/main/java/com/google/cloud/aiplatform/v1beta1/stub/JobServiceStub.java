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
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the JobService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class JobServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateCustomJobRequest, CustomJob> createCustomJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomJobCallable()");
  }

  public UnaryCallable<GetCustomJobRequest, CustomJob> getCustomJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomJobCallable()");
  }

  public UnaryCallable<ListCustomJobsRequest, ListCustomJobsPagedResponse>
      listCustomJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomJobsPagedCallable()");
  }

  public UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse> listCustomJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomJobsCallable()");
  }

  public OperationCallable<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCustomJobOperationCallable()");
  }

  public UnaryCallable<DeleteCustomJobRequest, Operation> deleteCustomJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCustomJobCallable()");
  }

  public UnaryCallable<CancelCustomJobRequest, Empty> cancelCustomJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCustomJobCallable()");
  }

  public UnaryCallable<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataLabelingJobCallable()");
  }

  public UnaryCallable<GetDataLabelingJobRequest, DataLabelingJob> getDataLabelingJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataLabelingJobCallable()");
  }

  public UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataLabelingJobsPagedCallable()");
  }

  public UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataLabelingJobsCallable()");
  }

  public OperationCallable<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDataLabelingJobOperationCallable()");
  }

  public UnaryCallable<DeleteDataLabelingJobRequest, Operation> deleteDataLabelingJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataLabelingJobCallable()");
  }

  public UnaryCallable<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelDataLabelingJobCallable()");
  }

  public UnaryCallable<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createHyperparameterTuningJobCallable()");
  }

  public UnaryCallable<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getHyperparameterTuningJobCallable()");
  }

  public UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listHyperparameterTuningJobsPagedCallable()");
  }

  public UnaryCallable<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listHyperparameterTuningJobsCallable()");
  }

  public OperationCallable<DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteHyperparameterTuningJobOperationCallable()");
  }

  public UnaryCallable<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteHyperparameterTuningJobCallable()");
  }

  public UnaryCallable<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: cancelHyperparameterTuningJobCallable()");
  }

  public UnaryCallable<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createBatchPredictionJobCallable()");
  }

  public UnaryCallable<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getBatchPredictionJobCallable()");
  }

  public UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBatchPredictionJobsPagedCallable()");
  }

  public UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBatchPredictionJobsCallable()");
  }

  public OperationCallable<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBatchPredictionJobOperationCallable()");
  }

  public UnaryCallable<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBatchPredictionJobCallable()");
  }

  public UnaryCallable<CancelBatchPredictionJobRequest, Empty> cancelBatchPredictionJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelBatchPredictionJobCallable()");
  }

  @Override
  public abstract void close();
}
