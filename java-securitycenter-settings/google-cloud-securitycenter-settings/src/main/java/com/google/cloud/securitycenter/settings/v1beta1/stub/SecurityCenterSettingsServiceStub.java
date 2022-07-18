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

package com.google.cloud.securitycenter.settings.v1beta1.stub;

import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListComponentsPagedResponse;
import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListDetectorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings;
import com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest;
import com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount;
import com.google.cloud.securitycenter.settings.v1beta1.Settings;
import com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecurityCenterSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class SecurityCenterSettingsServiceStub implements BackgroundResource {

  public UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceAccountCallable()");
  }

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
  }

  public UnaryCallable<ResetSettingsRequest, Empty> resetSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: resetSettingsCallable()");
  }

  public UnaryCallable<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetSettingsCallable()");
  }

  public UnaryCallable<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: calculateEffectiveSettingsCallable()");
  }

  public UnaryCallable<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCalculateEffectiveSettingsCallable()");
  }

  public UnaryCallable<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getComponentSettingsCallable()");
  }

  public UnaryCallable<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateComponentSettingsCallable()");
  }

  public UnaryCallable<ResetComponentSettingsRequest, Empty> resetComponentSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: resetComponentSettingsCallable()");
  }

  public UnaryCallable<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: calculateEffectiveComponentSettingsCallable()");
  }

  public UnaryCallable<ListDetectorsRequest, ListDetectorsPagedResponse>
      listDetectorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDetectorsPagedCallable()");
  }

  public UnaryCallable<ListDetectorsRequest, ListDetectorsResponse> listDetectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDetectorsCallable()");
  }

  public UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listComponentsPagedCallable()");
  }

  public UnaryCallable<ListComponentsRequest, ListComponentsResponse> listComponentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listComponentsCallable()");
  }

  @Override
  public abstract void close();
}
