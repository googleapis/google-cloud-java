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

import static com.google.ads.admanager.v1.ContentLabelServiceClient.ListContentLabelsPagedResponse;

import com.google.ads.admanager.v1.ContentLabel;
import com.google.ads.admanager.v1.GetContentLabelRequest;
import com.google.ads.admanager.v1.ListContentLabelsRequest;
import com.google.ads.admanager.v1.ListContentLabelsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ContentLabelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ContentLabelServiceStub implements BackgroundResource {

  public UnaryCallable<GetContentLabelRequest, ContentLabel> getContentLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: getContentLabelCallable()");
  }

  public UnaryCallable<ListContentLabelsRequest, ListContentLabelsPagedResponse>
      listContentLabelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listContentLabelsPagedCallable()");
  }

  public UnaryCallable<ListContentLabelsRequest, ListContentLabelsResponse>
      listContentLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listContentLabelsCallable()");
  }

  @Override
  public abstract void close();
}
