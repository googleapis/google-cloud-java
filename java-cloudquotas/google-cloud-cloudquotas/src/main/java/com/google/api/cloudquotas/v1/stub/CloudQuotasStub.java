/*
 * Copyright 2023 Google LLC
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

package com.google.api.cloudquotas.v1.stub;

import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaInfosPagedResponse;
import static com.google.api.cloudquotas.v1.CloudQuotasClient.ListQuotaPreferencesPagedResponse;

import com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.GetQuotaInfoRequest;
import com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosRequest;
import com.google.api.cloudquotas.v1.ListQuotaInfosResponse;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest;
import com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse;
import com.google.api.cloudquotas.v1.QuotaInfo;
import com.google.api.cloudquotas.v1.QuotaPreference;
import com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudQuotas service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudQuotasStub implements BackgroundResource {

  public UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosPagedResponse>
      listQuotaInfosPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQuotaInfosPagedCallable()");
  }

  public UnaryCallable<ListQuotaInfosRequest, ListQuotaInfosResponse> listQuotaInfosCallable() {
    throw new UnsupportedOperationException("Not implemented: listQuotaInfosCallable()");
  }

  public UnaryCallable<GetQuotaInfoRequest, QuotaInfo> getQuotaInfoCallable() {
    throw new UnsupportedOperationException("Not implemented: getQuotaInfoCallable()");
  }

  public UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesPagedResponse>
      listQuotaPreferencesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQuotaPreferencesPagedCallable()");
  }

  public UnaryCallable<ListQuotaPreferencesRequest, ListQuotaPreferencesResponse>
      listQuotaPreferencesCallable() {
    throw new UnsupportedOperationException("Not implemented: listQuotaPreferencesCallable()");
  }

  public UnaryCallable<GetQuotaPreferenceRequest, QuotaPreference> getQuotaPreferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: getQuotaPreferenceCallable()");
  }

  public UnaryCallable<CreateQuotaPreferenceRequest, QuotaPreference>
      createQuotaPreferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: createQuotaPreferenceCallable()");
  }

  public UnaryCallable<UpdateQuotaPreferenceRequest, QuotaPreference>
      updateQuotaPreferenceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateQuotaPreferenceCallable()");
  }

  @Override
  public abstract void close();
}
