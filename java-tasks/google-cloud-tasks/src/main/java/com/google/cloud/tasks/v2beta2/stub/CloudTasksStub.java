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

package com.google.cloud.tasks.v2beta2.stub;

import static com.google.cloud.tasks.v2beta2.CloudTasksClient.ListQueuesPagedResponse;
import static com.google.cloud.tasks.v2beta2.CloudTasksClient.ListTasksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.tasks.v2beta2.AcknowledgeTaskRequest;
import com.google.cloud.tasks.v2beta2.CancelLeaseRequest;
import com.google.cloud.tasks.v2beta2.CreateQueueRequest;
import com.google.cloud.tasks.v2beta2.CreateTaskRequest;
import com.google.cloud.tasks.v2beta2.DeleteQueueRequest;
import com.google.cloud.tasks.v2beta2.DeleteTaskRequest;
import com.google.cloud.tasks.v2beta2.GetQueueRequest;
import com.google.cloud.tasks.v2beta2.GetTaskRequest;
import com.google.cloud.tasks.v2beta2.LeaseTasksRequest;
import com.google.cloud.tasks.v2beta2.LeaseTasksResponse;
import com.google.cloud.tasks.v2beta2.ListQueuesRequest;
import com.google.cloud.tasks.v2beta2.ListQueuesResponse;
import com.google.cloud.tasks.v2beta2.ListTasksRequest;
import com.google.cloud.tasks.v2beta2.ListTasksResponse;
import com.google.cloud.tasks.v2beta2.PauseQueueRequest;
import com.google.cloud.tasks.v2beta2.PurgeQueueRequest;
import com.google.cloud.tasks.v2beta2.Queue;
import com.google.cloud.tasks.v2beta2.RenewLeaseRequest;
import com.google.cloud.tasks.v2beta2.ResumeQueueRequest;
import com.google.cloud.tasks.v2beta2.RunTaskRequest;
import com.google.cloud.tasks.v2beta2.Task;
import com.google.cloud.tasks.v2beta2.UpdateQueueRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudTasks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class CloudTasksStub implements BackgroundResource {

  public UnaryCallable<ListQueuesRequest, ListQueuesPagedResponse> listQueuesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQueuesPagedCallable()");
  }

  public UnaryCallable<ListQueuesRequest, ListQueuesResponse> listQueuesCallable() {
    throw new UnsupportedOperationException("Not implemented: listQueuesCallable()");
  }

  public UnaryCallable<GetQueueRequest, Queue> getQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: getQueueCallable()");
  }

  public UnaryCallable<CreateQueueRequest, Queue> createQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: createQueueCallable()");
  }

  public UnaryCallable<UpdateQueueRequest, Queue> updateQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: updateQueueCallable()");
  }

  public UnaryCallable<DeleteQueueRequest, Empty> deleteQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteQueueCallable()");
  }

  public UnaryCallable<PurgeQueueRequest, Queue> purgeQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeQueueCallable()");
  }

  public UnaryCallable<PauseQueueRequest, Queue> pauseQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseQueueCallable()");
  }

  public UnaryCallable<ResumeQueueRequest, Queue> resumeQueueCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeQueueCallable()");
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

  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksPagedCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksCallable()");
  }

  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: getTaskCallable()");
  }

  public UnaryCallable<CreateTaskRequest, Task> createTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: createTaskCallable()");
  }

  public UnaryCallable<DeleteTaskRequest, Empty> deleteTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTaskCallable()");
  }

  public UnaryCallable<LeaseTasksRequest, LeaseTasksResponse> leaseTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: leaseTasksCallable()");
  }

  public UnaryCallable<AcknowledgeTaskRequest, Empty> acknowledgeTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: acknowledgeTaskCallable()");
  }

  public UnaryCallable<RenewLeaseRequest, Task> renewLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: renewLeaseCallable()");
  }

  public UnaryCallable<CancelLeaseRequest, Task> cancelLeaseCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelLeaseCallable()");
  }

  public UnaryCallable<RunTaskRequest, Task> runTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: runTaskCallable()");
  }

  @Override
  public abstract void close();
}
