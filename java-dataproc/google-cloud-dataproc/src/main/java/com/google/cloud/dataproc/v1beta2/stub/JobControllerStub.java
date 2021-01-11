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

package com.google.cloud.dataproc.v1beta2.stub;

import static com.google.cloud.dataproc.v1beta2.JobControllerClient.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1beta2.CancelJobRequest;
import com.google.cloud.dataproc.v1beta2.DeleteJobRequest;
import com.google.cloud.dataproc.v1beta2.GetJobRequest;
import com.google.cloud.dataproc.v1beta2.Job;
import com.google.cloud.dataproc.v1beta2.JobMetadata;
import com.google.cloud.dataproc.v1beta2.ListJobsRequest;
import com.google.cloud.dataproc.v1beta2.ListJobsResponse;
import com.google.cloud.dataproc.v1beta2.SubmitJobRequest;
import com.google.cloud.dataproc.v1beta2.UpdateJobRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the JobController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class JobControllerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<SubmitJobRequest, Job> submitJobCallable() {
    throw new UnsupportedOperationException("Not implemented: submitJobCallable()");
  }

  public OperationCallable<SubmitJobRequest, Job, JobMetadata>
      submitJobAsOperationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: submitJobAsOperationOperationCallable()");
  }

  public UnaryCallable<SubmitJobRequest, Operation> submitJobAsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: submitJobAsOperationCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobCallable()");
  }

  public UnaryCallable<CancelJobRequest, Job> cancelJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelJobCallable()");
  }

  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobCallable()");
  }

  @Override
  public abstract void close();
}
