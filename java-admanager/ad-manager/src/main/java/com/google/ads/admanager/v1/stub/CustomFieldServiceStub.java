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

import static com.google.ads.admanager.v1.CustomFieldServiceClient.ListCustomFieldsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchActivateCustomFieldsResponse;
import com.google.ads.admanager.v1.BatchCreateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchCreateCustomFieldsResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomFieldsResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomFieldsResponse;
import com.google.ads.admanager.v1.CreateCustomFieldRequest;
import com.google.ads.admanager.v1.CustomField;
import com.google.ads.admanager.v1.GetCustomFieldRequest;
import com.google.ads.admanager.v1.ListCustomFieldsRequest;
import com.google.ads.admanager.v1.ListCustomFieldsResponse;
import com.google.ads.admanager.v1.UpdateCustomFieldRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CustomFieldService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CustomFieldServiceStub implements BackgroundResource {

  public UnaryCallable<GetCustomFieldRequest, CustomField> getCustomFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: getCustomFieldCallable()");
  }

  public UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsPagedResponse>
      listCustomFieldsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomFieldsPagedCallable()");
  }

  public UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsResponse>
      listCustomFieldsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCustomFieldsCallable()");
  }

  public UnaryCallable<CreateCustomFieldRequest, CustomField> createCustomFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: createCustomFieldCallable()");
  }

  public UnaryCallable<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
      batchCreateCustomFieldsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateCustomFieldsCallable()");
  }

  public UnaryCallable<UpdateCustomFieldRequest, CustomField> updateCustomFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCustomFieldCallable()");
  }

  public UnaryCallable<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
      batchUpdateCustomFieldsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateCustomFieldsCallable()");
  }

  public UnaryCallable<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
      batchActivateCustomFieldsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateCustomFieldsCallable()");
  }

  public UnaryCallable<BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
      batchDeactivateCustomFieldsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateCustomFieldsCallable()");
  }

  @Override
  public abstract void close();
}
