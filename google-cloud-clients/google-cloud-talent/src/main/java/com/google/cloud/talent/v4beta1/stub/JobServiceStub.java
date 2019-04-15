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
package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.JobServiceClient.ListJobsPagedResponse;
import static com.google.cloud.talent.v4beta1.JobServiceClient.SearchJobsForAlertPagedResponse;
import static com.google.cloud.talent.v4beta1.JobServiceClient.SearchJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4beta1.CreateJobRequest;
import com.google.cloud.talent.v4beta1.DeleteJobRequest;
import com.google.cloud.talent.v4beta1.GetJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.ListJobsRequest;
import com.google.cloud.talent.v4beta1.ListJobsResponse;
import com.google.cloud.talent.v4beta1.SearchJobsRequest;
import com.google.cloud.talent.v4beta1.SearchJobsResponse;
import com.google.cloud.talent.v4beta1.UpdateJobRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Talent Solution API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class JobServiceStub implements BackgroundResource {

  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobCallable()");
  }

  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<BatchDeleteJobsRequest, Empty> batchDeleteJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteJobsCallable()");
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsPagedResponse> searchJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchJobsPagedCallable()");
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchJobsCallable()");
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsForAlertPagedResponse>
      searchJobsForAlertPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchJobsForAlertPagedCallable()");
  }

  public UnaryCallable<SearchJobsRequest, SearchJobsResponse> searchJobsForAlertCallable() {
    throw new UnsupportedOperationException("Not implemented: searchJobsForAlertCallable()");
  }

  @Override
  public abstract void close();
}
