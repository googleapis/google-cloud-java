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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.JobsV1Beta3Client.AggregatedListJobsPagedResponse;
import static com.google.dataflow.v1beta3.JobsV1Beta3Client.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.CheckActiveJobsRequest;
import com.google.dataflow.v1beta3.CheckActiveJobsResponse;
import com.google.dataflow.v1beta3.CreateJobRequest;
import com.google.dataflow.v1beta3.GetJobRequest;
import com.google.dataflow.v1beta3.Job;
import com.google.dataflow.v1beta3.ListJobsRequest;
import com.google.dataflow.v1beta3.ListJobsResponse;
import com.google.dataflow.v1beta3.Snapshot;
import com.google.dataflow.v1beta3.SnapshotJobRequest;
import com.google.dataflow.v1beta3.UpdateJobRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the JobsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class JobsV1Beta3Stub implements BackgroundResource {

  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<ListJobsRequest, AggregatedListJobsPagedResponse>
      aggregatedListJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> aggregatedListJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListJobsCallable()");
  }

  public UnaryCallable<CheckActiveJobsRequest, CheckActiveJobsResponse> checkActiveJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: checkActiveJobsCallable()");
  }

  public UnaryCallable<SnapshotJobRequest, Snapshot> snapshotJobCallable() {
    throw new UnsupportedOperationException("Not implemented: snapshotJobCallable()");
  }

  @Override
  public abstract void close();
}
