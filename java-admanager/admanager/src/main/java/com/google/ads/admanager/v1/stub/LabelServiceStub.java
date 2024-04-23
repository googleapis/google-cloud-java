/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.LabelServiceClient.ListLabelsPagedResponse;

import com.google.ads.admanager.v1.GetLabelRequest;
import com.google.ads.admanager.v1.Label;
import com.google.ads.admanager.v1.ListLabelsRequest;
import com.google.ads.admanager.v1.ListLabelsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LabelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LabelServiceStub implements BackgroundResource {

  public UnaryCallable<GetLabelRequest, Label> getLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: getLabelCallable()");
  }

  public UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLabelsPagedCallable()");
  }

  public UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLabelsCallable()");
  }

  @Override
  public abstract void close();
}
