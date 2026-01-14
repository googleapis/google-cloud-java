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

package com.google.cloud.gkerecommender.v1.stub;

import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServerVersionsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServersPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchProfilesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServersRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServersResponse;
import com.google.cloud.gkerecommender.v1.FetchModelsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelsResponse;
import com.google.cloud.gkerecommender.v1.FetchProfilesRequest;
import com.google.cloud.gkerecommender.v1.FetchProfilesResponse;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GkeInferenceQuickstart service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GkeInferenceQuickstartStub implements BackgroundResource {

  public UnaryCallable<FetchModelsRequest, FetchModelsPagedResponse> fetchModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchModelsPagedCallable()");
  }

  public UnaryCallable<FetchModelsRequest, FetchModelsResponse> fetchModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchModelsCallable()");
  }

  public UnaryCallable<FetchModelServersRequest, FetchModelServersPagedResponse>
      fetchModelServersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchModelServersPagedCallable()");
  }

  public UnaryCallable<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchModelServersCallable()");
  }

  public UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchModelServerVersionsPagedCallable()");
  }

  public UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchModelServerVersionsCallable()");
  }

  public UnaryCallable<FetchProfilesRequest, FetchProfilesPagedResponse>
      fetchProfilesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchProfilesPagedCallable()");
  }

  public UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchProfilesCallable()");
  }

  public UnaryCallable<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestCallable() {
    throw new UnsupportedOperationException("Not implemented: generateOptimizedManifestCallable()");
  }

  public UnaryCallable<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchBenchmarkingDataCallable()");
  }

  @Override
  public abstract void close();
}
