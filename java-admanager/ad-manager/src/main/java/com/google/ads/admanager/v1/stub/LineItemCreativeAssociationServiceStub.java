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

import static com.google.ads.admanager.v1.LineItemCreativeAssociationServiceClient.ListLineItemCreativeAssociationsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchActivateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchCreateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchCreateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchDeactivateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchDeactivateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.BatchDeleteLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.BatchUpdateLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.CreateLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.GetLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.LineItemCreativeAssociation;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsResponse;
import com.google.ads.admanager.v1.PreviewLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.PreviewLineItemCreativeAssociationResponse;
import com.google.ads.admanager.v1.UpdateLineItemCreativeAssociationRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the LineItemCreativeAssociationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class LineItemCreativeAssociationServiceStub implements BackgroundResource {

  public UnaryCallable<GetLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      getLineItemCreativeAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getLineItemCreativeAssociationCallable()");
  }

  public UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsPagedResponse>
      listLineItemCreativeAssociationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLineItemCreativeAssociationsPagedCallable()");
  }

  public UnaryCallable<
          ListLineItemCreativeAssociationsRequest, ListLineItemCreativeAssociationsResponse>
      listLineItemCreativeAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLineItemCreativeAssociationsCallable()");
  }

  public UnaryCallable<CreateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      createLineItemCreativeAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createLineItemCreativeAssociationCallable()");
  }

  public UnaryCallable<
          BatchCreateLineItemCreativeAssociationsRequest,
          BatchCreateLineItemCreativeAssociationsResponse>
      batchCreateLineItemCreativeAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateLineItemCreativeAssociationsCallable()");
  }

  public UnaryCallable<UpdateLineItemCreativeAssociationRequest, LineItemCreativeAssociation>
      updateLineItemCreativeAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateLineItemCreativeAssociationCallable()");
  }

  public UnaryCallable<
          BatchUpdateLineItemCreativeAssociationsRequest,
          BatchUpdateLineItemCreativeAssociationsResponse>
      batchUpdateLineItemCreativeAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateLineItemCreativeAssociationsCallable()");
  }

  public UnaryCallable<
          BatchActivateLineItemCreativeAssociationsRequest,
          BatchActivateLineItemCreativeAssociationsResponse>
      batchActivateLineItemCreativeAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateLineItemCreativeAssociationsCallable()");
  }

  public UnaryCallable<
          BatchDeactivateLineItemCreativeAssociationsRequest,
          BatchDeactivateLineItemCreativeAssociationsResponse>
      batchDeactivateLineItemCreativeAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateLineItemCreativeAssociationsCallable()");
  }

  public UnaryCallable<BatchDeleteLineItemCreativeAssociationsRequest, Empty>
      batchDeleteLineItemCreativeAssociationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteLineItemCreativeAssociationsCallable()");
  }

  public UnaryCallable<
          PreviewLineItemCreativeAssociationRequest, PreviewLineItemCreativeAssociationResponse>
      previewLineItemCreativeAssociationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: previewLineItemCreativeAssociationCallable()");
  }

  @Override
  public abstract void close();
}
