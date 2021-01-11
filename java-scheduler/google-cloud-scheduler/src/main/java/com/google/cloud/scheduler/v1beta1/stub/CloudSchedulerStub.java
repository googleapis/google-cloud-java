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

package com.google.cloud.scheduler.v1beta1.stub;

import static com.google.cloud.scheduler.v1beta1.CloudSchedulerClient.ListJobsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.scheduler.v1beta1.CreateJobRequest;
import com.google.cloud.scheduler.v1beta1.DeleteJobRequest;
import com.google.cloud.scheduler.v1beta1.GetJobRequest;
import com.google.cloud.scheduler.v1beta1.Job;
import com.google.cloud.scheduler.v1beta1.ListJobsRequest;
import com.google.cloud.scheduler.v1beta1.ListJobsResponse;
import com.google.cloud.scheduler.v1beta1.PauseJobRequest;
import com.google.cloud.scheduler.v1beta1.ResumeJobRequest;
import com.google.cloud.scheduler.v1beta1.RunJobRequest;
import com.google.cloud.scheduler.v1beta1.UpdateJobRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudScheduler service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CloudSchedulerStub implements BackgroundResource {

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobCallable()");
  }

  public UnaryCallable<UpdateJobRequest, Job> updateJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobCallable()");
  }

  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobCallable()");
  }

  public UnaryCallable<PauseJobRequest, Job> pauseJobCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseJobCallable()");
  }

  public UnaryCallable<ResumeJobRequest, Job> resumeJobCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeJobCallable()");
  }

  public UnaryCallable<RunJobRequest, Job> runJobCallable() {
    throw new UnsupportedOperationException("Not implemented: runJobCallable()");
  }

  @Override
  public abstract void close();
}
