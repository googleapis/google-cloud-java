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

import static com.google.ads.admanager.v1.SlateServiceClient.ListSlatesPagedResponse;

import com.google.ads.admanager.v1.BatchArchiveSlatesRequest;
import com.google.ads.admanager.v1.BatchArchiveSlatesResponse;
import com.google.ads.admanager.v1.BatchCreateSlatesRequest;
import com.google.ads.admanager.v1.BatchCreateSlatesResponse;
import com.google.ads.admanager.v1.BatchUnarchiveSlatesRequest;
import com.google.ads.admanager.v1.BatchUnarchiveSlatesResponse;
import com.google.ads.admanager.v1.BatchUpdateSlatesRequest;
import com.google.ads.admanager.v1.BatchUpdateSlatesResponse;
import com.google.ads.admanager.v1.CreateSlateRequest;
import com.google.ads.admanager.v1.GetSlateRequest;
import com.google.ads.admanager.v1.ListSlatesRequest;
import com.google.ads.admanager.v1.ListSlatesResponse;
import com.google.ads.admanager.v1.Slate;
import com.google.ads.admanager.v1.UpdateSlateRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SlateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class SlateServiceStub implements BackgroundResource {

  public UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: getSlateCallable()");
  }

  public UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSlatesPagedCallable()");
  }

  public UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSlatesCallable()");
  }

  public UnaryCallable<CreateSlateRequest, Slate> createSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: createSlateCallable()");
  }

  public UnaryCallable<BatchCreateSlatesRequest, BatchCreateSlatesResponse>
      batchCreateSlatesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateSlatesCallable()");
  }

  public UnaryCallable<UpdateSlateRequest, Slate> updateSlateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSlateCallable()");
  }

  public UnaryCallable<BatchUpdateSlatesRequest, BatchUpdateSlatesResponse>
      batchUpdateSlatesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateSlatesCallable()");
  }

  public UnaryCallable<BatchArchiveSlatesRequest, BatchArchiveSlatesResponse>
      batchArchiveSlatesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveSlatesCallable()");
  }

  public UnaryCallable<BatchUnarchiveSlatesRequest, BatchUnarchiveSlatesResponse>
      batchUnarchiveSlatesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUnarchiveSlatesCallable()");
  }

  @Override
  public abstract void close();
}
