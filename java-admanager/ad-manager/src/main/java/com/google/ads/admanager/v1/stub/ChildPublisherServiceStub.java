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

import static com.google.ads.admanager.v1.ChildPublisherServiceClient.ListChildPublishersPagedResponse;

import com.google.ads.admanager.v1.BatchCreateChildPublishersRequest;
import com.google.ads.admanager.v1.BatchCreateChildPublishersResponse;
import com.google.ads.admanager.v1.BatchUpdateChildPublishersRequest;
import com.google.ads.admanager.v1.BatchUpdateChildPublishersResponse;
import com.google.ads.admanager.v1.ChildPublisher;
import com.google.ads.admanager.v1.CreateChildPublisherRequest;
import com.google.ads.admanager.v1.GetChildPublisherRequest;
import com.google.ads.admanager.v1.ListChildPublishersRequest;
import com.google.ads.admanager.v1.ListChildPublishersResponse;
import com.google.ads.admanager.v1.UpdateChildPublisherRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ChildPublisherService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ChildPublisherServiceStub implements BackgroundResource {

  public UnaryCallable<GetChildPublisherRequest, ChildPublisher> getChildPublisherCallable() {
    throw new UnsupportedOperationException("Not implemented: getChildPublisherCallable()");
  }

  public UnaryCallable<ListChildPublishersRequest, ListChildPublishersPagedResponse>
      listChildPublishersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChildPublishersPagedCallable()");
  }

  public UnaryCallable<ListChildPublishersRequest, ListChildPublishersResponse>
      listChildPublishersCallable() {
    throw new UnsupportedOperationException("Not implemented: listChildPublishersCallable()");
  }

  public UnaryCallable<CreateChildPublisherRequest, ChildPublisher> createChildPublisherCallable() {
    throw new UnsupportedOperationException("Not implemented: createChildPublisherCallable()");
  }

  public UnaryCallable<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateChildPublishersCallable()");
  }

  public UnaryCallable<UpdateChildPublisherRequest, ChildPublisher> updateChildPublisherCallable() {
    throw new UnsupportedOperationException("Not implemented: updateChildPublisherCallable()");
  }

  public UnaryCallable<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateChildPublishersCallable()");
  }

  @Override
  public abstract void close();
}
