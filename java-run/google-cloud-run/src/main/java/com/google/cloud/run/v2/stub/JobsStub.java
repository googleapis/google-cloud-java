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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.JobsClient.ListJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.CreateJobRequest;
import com.google.cloud.run.v2.DeleteJobRequest;
import com.google.cloud.run.v2.Execution;
import com.google.cloud.run.v2.GetJobRequest;
import com.google.cloud.run.v2.Job;
import com.google.cloud.run.v2.ListJobsRequest;
import com.google.cloud.run.v2.ListJobsResponse;
import com.google.cloud.run.v2.RunJobRequest;
import com.google.cloud.run.v2.UpdateJobRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Jobs service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class JobsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateJobRequest, Job, Job> createJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobOperationCallable()");
  }

  public UnaryCallable<CreateJobRequest, Operation> createJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobCallable()");
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

  public OperationCallable<UpdateJobRequest, Job, Job> updateJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobOperationCallable()");
  }

  public UnaryCallable<UpdateJobRequest, Operation> updateJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobCallable()");
  }

  public OperationCallable<DeleteJobRequest, Job, Job> deleteJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobOperationCallable()");
  }

  public UnaryCallable<DeleteJobRequest, Operation> deleteJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobCallable()");
  }

  public OperationCallable<RunJobRequest, Execution, Execution> runJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runJobOperationCallable()");
  }

  public UnaryCallable<RunJobRequest, Operation> runJobCallable() {
    throw new UnsupportedOperationException("Not implemented: runJobCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
