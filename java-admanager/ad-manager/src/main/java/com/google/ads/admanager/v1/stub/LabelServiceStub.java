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

import static com.google.ads.admanager.v1.LabelServiceClient.ListLabelsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLabelsRequest;
import com.google.ads.admanager.v1.BatchActivateLabelsResponse;
import com.google.ads.admanager.v1.BatchCreateLabelsRequest;
import com.google.ads.admanager.v1.BatchCreateLabelsResponse;
import com.google.ads.admanager.v1.BatchDeactivateLabelsRequest;
import com.google.ads.admanager.v1.BatchDeactivateLabelsResponse;
import com.google.ads.admanager.v1.BatchUpdateLabelsRequest;
import com.google.ads.admanager.v1.BatchUpdateLabelsResponse;
import com.google.ads.admanager.v1.CreateLabelRequest;
import com.google.ads.admanager.v1.GetLabelRequest;
import com.google.ads.admanager.v1.Label;
import com.google.ads.admanager.v1.ListLabelsRequest;
import com.google.ads.admanager.v1.ListLabelsResponse;
import com.google.ads.admanager.v1.UpdateLabelRequest;
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

  public UnaryCallable<CreateLabelRequest, Label> createLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: createLabelCallable()");
  }

  public UnaryCallable<BatchCreateLabelsRequest, BatchCreateLabelsResponse>
      batchCreateLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateLabelsCallable()");
  }

  public UnaryCallable<UpdateLabelRequest, Label> updateLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLabelCallable()");
  }

  public UnaryCallable<BatchUpdateLabelsRequest, BatchUpdateLabelsResponse>
      batchUpdateLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateLabelsCallable()");
  }

  public UnaryCallable<BatchActivateLabelsRequest, BatchActivateLabelsResponse>
      batchActivateLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateLabelsCallable()");
  }

  public UnaryCallable<BatchDeactivateLabelsRequest, BatchDeactivateLabelsResponse>
      batchDeactivateLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivateLabelsCallable()");
  }

  @Override
  public abstract void close();
}
