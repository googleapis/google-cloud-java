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

package com.google.cloud.video.transcoder.v1.stub;

import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobTemplatesPagedResponse;
import static com.google.cloud.video.transcoder.v1.TranscoderServiceClient.ListJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.video.transcoder.v1.CreateJobRequest;
import com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.DeleteJobRequest;
import com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.GetJobRequest;
import com.google.cloud.video.transcoder.v1.GetJobTemplateRequest;
import com.google.cloud.video.transcoder.v1.Job;
import com.google.cloud.video.transcoder.v1.JobTemplate;
import com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest;
import com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse;
import com.google.cloud.video.transcoder.v1.ListJobsRequest;
import com.google.cloud.video.transcoder.v1.ListJobsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TranscoderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TranscoderServiceStub implements BackgroundResource {

  public UnaryCallable<CreateJobRequest, Job> createJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsPagedResponse> listJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsPagedCallable()");
  }

  public UnaryCallable<ListJobsRequest, ListJobsResponse> listJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobsCallable()");
  }

  public UnaryCallable<GetJobRequest, Job> getJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobCallable()");
  }

  public UnaryCallable<DeleteJobRequest, Empty> deleteJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobCallable()");
  }

  public UnaryCallable<CreateJobTemplateRequest, JobTemplate> createJobTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobTemplateCallable()");
  }

  public UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesPagedResponse>
      listJobTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobTemplatesPagedCallable()");
  }

  public UnaryCallable<ListJobTemplatesRequest, ListJobTemplatesResponse>
      listJobTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobTemplatesCallable()");
  }

  public UnaryCallable<GetJobTemplateRequest, JobTemplate> getJobTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobTemplateCallable()");
  }

  public UnaryCallable<DeleteJobTemplateRequest, Empty> deleteJobTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobTemplateCallable()");
  }

  @Override
  public abstract void close();
}
