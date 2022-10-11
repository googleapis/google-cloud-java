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

package com.google.cloud.recaptchaenterprise.v1.stub;

import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListKeysPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListRelatedAccountGroupMembershipsPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListRelatedAccountGroupsPagedResponse;
import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.SearchRelatedAccountGroupMembershipsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.GetMetricsRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ListKeysResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse;
import com.google.recaptchaenterprise.v1.Metrics;
import com.google.recaptchaenterprise.v1.MigrateKeyRequest;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RecaptchaEnterpriseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RecaptchaEnterpriseServiceStub implements BackgroundResource {

  public UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssessmentCallable()");
  }

  public UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable() {
    throw new UnsupportedOperationException("Not implemented: annotateAssessmentCallable()");
  }

  public UnaryCallable<CreateKeyRequest, Key> createKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createKeyCallable()");
  }

  public UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listKeysPagedCallable()");
  }

  public UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listKeysCallable()");
  }

  public UnaryCallable<RetrieveLegacySecretKeyRequest, RetrieveLegacySecretKeyResponse>
      retrieveLegacySecretKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: retrieveLegacySecretKeyCallable()");
  }

  public UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getKeyCallable()");
  }

  public UnaryCallable<UpdateKeyRequest, Key> updateKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateKeyCallable()");
  }

  public UnaryCallable<DeleteKeyRequest, Empty> deleteKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteKeyCallable()");
  }

  public UnaryCallable<MigrateKeyRequest, Key> migrateKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: migrateKeyCallable()");
  }

  public UnaryCallable<GetMetricsRequest, Metrics> getMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: getMetricsCallable()");
  }

  public UnaryCallable<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsPagedResponse>
      listRelatedAccountGroupsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRelatedAccountGroupsPagedCallable()");
  }

  public UnaryCallable<ListRelatedAccountGroupsRequest, ListRelatedAccountGroupsResponse>
      listRelatedAccountGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRelatedAccountGroupsCallable()");
  }

  public UnaryCallable<
          ListRelatedAccountGroupMembershipsRequest,
          ListRelatedAccountGroupMembershipsPagedResponse>
      listRelatedAccountGroupMembershipsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRelatedAccountGroupMembershipsPagedCallable()");
  }

  public UnaryCallable<
          ListRelatedAccountGroupMembershipsRequest, ListRelatedAccountGroupMembershipsResponse>
      listRelatedAccountGroupMembershipsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRelatedAccountGroupMembershipsCallable()");
  }

  public UnaryCallable<
          SearchRelatedAccountGroupMembershipsRequest,
          SearchRelatedAccountGroupMembershipsPagedResponse>
      searchRelatedAccountGroupMembershipsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchRelatedAccountGroupMembershipsPagedCallable()");
  }

  public UnaryCallable<
          SearchRelatedAccountGroupMembershipsRequest, SearchRelatedAccountGroupMembershipsResponse>
      searchRelatedAccountGroupMembershipsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchRelatedAccountGroupMembershipsCallable()");
  }

  @Override
  public abstract void close();
}
