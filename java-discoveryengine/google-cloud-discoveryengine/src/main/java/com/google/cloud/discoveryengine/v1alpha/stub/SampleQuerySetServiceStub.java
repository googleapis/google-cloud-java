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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.SampleQuerySetServiceClient.ListSampleQuerySetsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.GetSampleQuerySetRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListSampleQuerySetsResponse;
import com.google.cloud.discoveryengine.v1alpha.SampleQuerySet;
import com.google.cloud.discoveryengine.v1alpha.UpdateSampleQuerySetRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SampleQuerySetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SampleQuerySetServiceStub implements BackgroundResource {

  public UnaryCallable<GetSampleQuerySetRequest, SampleQuerySet> getSampleQuerySetCallable() {
    throw new UnsupportedOperationException("Not implemented: getSampleQuerySetCallable()");
  }

  public UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsPagedResponse>
      listSampleQuerySetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSampleQuerySetsPagedCallable()");
  }

  public UnaryCallable<ListSampleQuerySetsRequest, ListSampleQuerySetsResponse>
      listSampleQuerySetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSampleQuerySetsCallable()");
  }

  public UnaryCallable<CreateSampleQuerySetRequest, SampleQuerySet> createSampleQuerySetCallable() {
    throw new UnsupportedOperationException("Not implemented: createSampleQuerySetCallable()");
  }

  public UnaryCallable<UpdateSampleQuerySetRequest, SampleQuerySet> updateSampleQuerySetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSampleQuerySetCallable()");
  }

  public UnaryCallable<DeleteSampleQuerySetRequest, Empty> deleteSampleQuerySetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSampleQuerySetCallable()");
  }

  @Override
  public abstract void close();
}
