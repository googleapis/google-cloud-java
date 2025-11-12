/*
 * Copyright 2025 Google LLC
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

import static com.google.ads.admanager.v1.ContentServiceClient.ListContentPagedResponse;

import com.google.ads.admanager.v1.Content;
import com.google.ads.admanager.v1.GetContentRequest;
import com.google.ads.admanager.v1.ListContentRequest;
import com.google.ads.admanager.v1.ListContentResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ContentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ContentServiceStub implements BackgroundResource {

  public UnaryCallable<GetContentRequest, Content> getContentCallable() {
    throw new UnsupportedOperationException("Not implemented: getContentCallable()");
  }

  public UnaryCallable<ListContentRequest, ListContentPagedResponse> listContentPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listContentPagedCallable()");
  }

  public UnaryCallable<ListContentRequest, ListContentResponse> listContentCallable() {
    throw new UnsupportedOperationException("Not implemented: listContentCallable()");
  }

  @Override
  public abstract void close();
}
