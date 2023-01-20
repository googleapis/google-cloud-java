/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.talent.v4.stub;

import static com.google.cloud.talent.v4.JobServiceClient.ListJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4.BatchCreateJobsRequest;
import com.google.cloud.talent.v4.BatchCreateJobsResponse;
import com.google.cloud.talent.v4.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4.BatchDeleteJobsResponse;
import com.google.cloud.talent.v4.BatchOperationMetadata;
import com.google.cloud.talent.v4.BatchUpdateJobsRequest;
import com.google.cloud.talent.v4.BatchUpdateJobsResponse;
import com.google.cloud.talent.v4.CreateJobRequest;
import com.google.cloud.talent.v4.DeleteJobRequest;
import com.google.cloud.talent.v4.GetJobRequest;
import com.google.cloud.talent.v4.Job;
import com.google.cloud.talent.v4.ListJobsRequest;
import com.google.cloud.talent.v4.ListJobsResponse;
import com.google.cloud.talent.v4.SearchJobsRequest;
import com.google.cloud.talent.v4.SearchJobsResponse;
import com.google.cloud.talent.v4.UpdateJobRequest;
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
@Generated("by gapic-generator-java")
public abstract class JobServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobCallable()");
  }

  public OperationCallable<BatchCreateJobsRequest, BatchCreateJobsResponse, BatchOperationMetadata>
      batchCreateJobsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateJobsOperationCallable()");
  }

  public UnaryCallable<BatchCreateJobsRequest, Operation> batchCreateJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateJobsCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobCallable()");
  }

  public OperationCallable<BatchUpdateJobsRequest, BatchUpdateJobsResponse, BatchOperationMetadata>
      batchUpdateJobsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateJobsOperationCallable()");
  }

  public UnaryCallable<BatchUpdateJobsRequest, Operation> batchUpdateJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateJobsCallable()");
  }

  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobCallable()");
  }

  public OperationCallable<BatchDeleteJobsRequest, BatchDeleteJobsResponse, BatchOperationMetadata>
      batchDeleteJobsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteJobsOperationCallable()");
  }

  public UnaryCallable<BatchDeleteJobsRequest, Operation> batchDeleteJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteJobsCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchJobsCallable()");
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable() {
    throw new UnsupportedOperationException("Not implemented: searchJobsForAlertCallable()");
  }

  @Override
  public abstract void close();
}
