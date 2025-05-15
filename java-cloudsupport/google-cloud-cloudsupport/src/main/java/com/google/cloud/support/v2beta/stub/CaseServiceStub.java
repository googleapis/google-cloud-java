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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2beta.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2beta.CaseServiceClient.SearchCasesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.Case;
import com.google.cloud.support.v2beta.CloseCaseRequest;
import com.google.cloud.support.v2beta.CreateCaseRequest;
import com.google.cloud.support.v2beta.EscalateCaseRequest;
import com.google.cloud.support.v2beta.GetCaseRequest;
import com.google.cloud.support.v2beta.ListCasesRequest;
import com.google.cloud.support.v2beta.ListCasesResponse;
import com.google.cloud.support.v2beta.SearchCaseClassificationsRequest;
import com.google.cloud.support.v2beta.SearchCaseClassificationsResponse;
import com.google.cloud.support.v2beta.SearchCasesRequest;
import com.google.cloud.support.v2beta.SearchCasesResponse;
import com.google.cloud.support.v2beta.UpdateCaseRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CaseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CaseServiceStub implements BackgroundResource {

  public UnaryCallable<GetCaseRequest, Case> getCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getCaseCallable()");
  }

  public UnaryCallable<ListCasesRequest, ListCasesPagedResponse> listCasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCasesPagedCallable()");
  }

  public UnaryCallable<ListCasesRequest, ListCasesResponse> listCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCasesCallable()");
  }

  public UnaryCallable<SearchCasesRequest, SearchCasesPagedResponse> searchCasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCasesPagedCallable()");
  }

  public UnaryCallable<SearchCasesRequest, SearchCasesResponse> searchCasesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCasesCallable()");
  }

  public UnaryCallable<CreateCaseRequest, Case> createCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createCaseCallable()");
  }

  public UnaryCallable<UpdateCaseRequest, Case> updateCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCaseCallable()");
  }

  public UnaryCallable<EscalateCaseRequest, Case> escalateCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: escalateCaseCallable()");
  }

  public UnaryCallable<CloseCaseRequest, Case> closeCaseCallable() {
    throw new UnsupportedOperationException("Not implemented: closeCaseCallable()");
  }

  public UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchCaseClassificationsPagedCallable()");
  }

  public UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCaseClassificationsCallable()");
  }

  @Override
  public abstract void close();
}
