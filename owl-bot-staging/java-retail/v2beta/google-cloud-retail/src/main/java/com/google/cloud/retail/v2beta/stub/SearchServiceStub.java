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

package com.google.cloud.retail.v2beta.stub;

import static com.google.cloud.retail.v2beta.SearchServiceClient.SearchPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.SearchRequest;
import com.google.cloud.retail.v2beta.SearchResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SearchServiceStub implements BackgroundResource {

  public UnaryCallable<SearchRequest, SearchPagedResponse> searchPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchPagedCallable()");
  }

  public UnaryCallable<SearchRequest, SearchResponse> searchCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCallable()");
  }

  @Override
  public abstract void close();
}
