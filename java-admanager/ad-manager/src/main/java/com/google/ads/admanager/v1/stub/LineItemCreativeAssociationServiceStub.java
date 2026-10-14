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

import com.google.ads.admanager.v1.GetLineItemCreativeAssociationRequest;
import com.google.ads.admanager.v1.LineItemCreativeAssociation;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsRequest;
import com.google.ads.admanager.v1.ListLineItemCreativeAssociationsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
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

  @Override
  public abstract void close();
}
