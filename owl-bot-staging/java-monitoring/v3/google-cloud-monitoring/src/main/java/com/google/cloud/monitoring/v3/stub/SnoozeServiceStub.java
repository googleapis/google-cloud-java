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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.SnoozeServiceClient.ListSnoozesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SnoozeService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SnoozeServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSnoozeRequest, Snooze> createSnoozeCallable() {
    throw new UnsupportedOperationException("Not implemented: createSnoozeCallable()");
  }

  public UnaryCallable<ListSnoozesRequest, ListSnoozesPagedResponse> listSnoozesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnoozesPagedCallable()");
  }

  public UnaryCallable<ListSnoozesRequest, ListSnoozesResponse> listSnoozesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSnoozesCallable()");
  }

  public UnaryCallable<GetSnoozeRequest, Snooze> getSnoozeCallable() {
    throw new UnsupportedOperationException("Not implemented: getSnoozeCallable()");
  }

  public UnaryCallable<UpdateSnoozeRequest, Snooze> updateSnoozeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSnoozeCallable()");
  }

  @Override
  public abstract void close();
}
