/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ChangeEventServiceClient.ListChangeEventsPagedResponse;

import com.google.ads.admanager.v1.ChangeEvent;
import com.google.ads.admanager.v1.GetChangeEventRequest;
import com.google.ads.admanager.v1.ListChangeEventsRequest;
import com.google.ads.admanager.v1.ListChangeEventsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ChangeEventService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ChangeEventServiceStub implements BackgroundResource {

  public UnaryCallable<GetChangeEventRequest, ChangeEvent> getChangeEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getChangeEventCallable()");
  }

  public UnaryCallable<ListChangeEventsRequest, ListChangeEventsPagedResponse>
      listChangeEventsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChangeEventsPagedCallable()");
  }

  public UnaryCallable<ListChangeEventsRequest, ListChangeEventsResponse>
      listChangeEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChangeEventsCallable()");
  }

  @Override
  public abstract void close();
}
