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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.SynonymSetServiceClient.ListSynonymSetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.DeleteSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.GetSynonymSetRequest;
import com.google.cloud.contentwarehouse.v1.ListSynonymSetsRequest;
import com.google.cloud.contentwarehouse.v1.ListSynonymSetsResponse;
import com.google.cloud.contentwarehouse.v1.SynonymSet;
import com.google.cloud.contentwarehouse.v1.UpdateSynonymSetRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SynonymSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SynonymSetServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSynonymSetRequest, SynonymSet> createSynonymSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createSynonymSetCallable()");
  }

  public UnaryCallable<GetSynonymSetRequest, SynonymSet> getSynonymSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getSynonymSetCallable()");
  }

  public UnaryCallable<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSynonymSetCallable()");
  }

  public UnaryCallable<DeleteSynonymSetRequest, Empty> deleteSynonymSetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSynonymSetCallable()");
  }

  public UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsPagedResponse>
      listSynonymSetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSynonymSetsPagedCallable()");
  }

  public UnaryCallable<ListSynonymSetsRequest, ListSynonymSetsResponse> listSynonymSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSynonymSetsCallable()");
  }

  @Override
  public abstract void close();
}
