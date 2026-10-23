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

import static com.google.ads.admanager.v1.LineItemTemplateServiceClient.ListLineItemTemplatesPagedResponse;

import com.google.ads.admanager.v1.GetLineItemTemplateRequest;
import com.google.ads.admanager.v1.LineItemTemplate;
import com.google.ads.admanager.v1.ListLineItemTemplatesRequest;
import com.google.ads.admanager.v1.ListLineItemTemplatesResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LineItemTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class LineItemTemplateServiceStub implements BackgroundResource {

  public UnaryCallable<GetLineItemTemplateRequest, LineItemTemplate> getLineItemTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getLineItemTemplateCallable()");
  }

  public UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesPagedResponse>
      listLineItemTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLineItemTemplatesPagedCallable()");
  }

  public UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>
      listLineItemTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listLineItemTemplatesCallable()");
  }

  @Override
  public abstract void close();
}
