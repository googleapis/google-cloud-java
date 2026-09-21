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

import static com.google.ads.admanager.v1.BreakTemplateServiceClient.ListBreakTemplatesPagedResponse;

import com.google.ads.admanager.v1.BatchCreateBreakTemplatesRequest;
import com.google.ads.admanager.v1.BatchCreateBreakTemplatesResponse;
import com.google.ads.admanager.v1.BatchUpdateBreakTemplatesRequest;
import com.google.ads.admanager.v1.BatchUpdateBreakTemplatesResponse;
import com.google.ads.admanager.v1.BreakTemplate;
import com.google.ads.admanager.v1.CreateBreakTemplateRequest;
import com.google.ads.admanager.v1.GetBreakTemplateRequest;
import com.google.ads.admanager.v1.ListBreakTemplatesRequest;
import com.google.ads.admanager.v1.ListBreakTemplatesResponse;
import com.google.ads.admanager.v1.UpdateBreakTemplateRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BreakTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class BreakTemplateServiceStub implements BackgroundResource {

  public UnaryCallable<GetBreakTemplateRequest, BreakTemplate> getBreakTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getBreakTemplateCallable()");
  }

  public UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesPagedResponse>
      listBreakTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBreakTemplatesPagedCallable()");
  }

  public UnaryCallable<ListBreakTemplatesRequest, ListBreakTemplatesResponse>
      listBreakTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listBreakTemplatesCallable()");
  }

  public UnaryCallable<CreateBreakTemplateRequest, BreakTemplate> createBreakTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createBreakTemplateCallable()");
  }

  public UnaryCallable<BatchCreateBreakTemplatesRequest, BatchCreateBreakTemplatesResponse>
      batchCreateBreakTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateBreakTemplatesCallable()");
  }

  public UnaryCallable<UpdateBreakTemplateRequest, BreakTemplate> updateBreakTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBreakTemplateCallable()");
  }

  public UnaryCallable<BatchUpdateBreakTemplatesRequest, BatchUpdateBreakTemplatesResponse>
      batchUpdateBreakTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateBreakTemplatesCallable()");
  }

  @Override
  public abstract void close();
}
