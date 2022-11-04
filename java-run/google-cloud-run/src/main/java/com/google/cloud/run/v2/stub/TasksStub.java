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

import static com.google.cloud.run.v2.TasksClient.ListTasksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.GetTaskRequest;
import com.google.cloud.run.v2.ListTasksRequest;
import com.google.cloud.run.v2.ListTasksResponse;
import com.google.cloud.run.v2.Task;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Tasks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TasksStub implements BackgroundResource {

  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: getTaskCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksPagedCallable()");
  }

  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: listTasksCallable()");
  }

  @Override
  public abstract void close();
}
