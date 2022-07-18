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

package com.google.cloud.talent.v4.stub;

import static com.google.cloud.talent.v4.CompanyServiceClient.ListCompaniesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4.Company;
import com.google.cloud.talent.v4.CreateCompanyRequest;
import com.google.cloud.talent.v4.DeleteCompanyRequest;
import com.google.cloud.talent.v4.GetCompanyRequest;
import com.google.cloud.talent.v4.ListCompaniesRequest;
import com.google.cloud.talent.v4.ListCompaniesResponse;
import com.google.cloud.talent.v4.UpdateCompanyRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CompanyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CompanyServiceStub implements BackgroundResource {

  public UnaryCallable<CreateCompanyRequest, Company> createCompanyCallable() {
    throw new UnsupportedOperationException("Not implemented: createCompanyCallable()");
  }

  public UnaryCallable<GetCompanyRequest, Company> getCompanyCallable() {
    throw new UnsupportedOperationException("Not implemented: getCompanyCallable()");
  }

  public UnaryCallable<UpdateCompanyRequest, Company> updateCompanyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCompanyCallable()");
  }

  public UnaryCallable<DeleteCompanyRequest, Empty> deleteCompanyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCompanyCallable()");
  }

  public UnaryCallable<ListCompaniesRequest, ListCompaniesPagedResponse>
      listCompaniesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCompaniesPagedCallable()");
  }

  public UnaryCallable<ListCompaniesRequest, ListCompaniesResponse> listCompaniesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCompaniesCallable()");
  }

  @Override
  public abstract void close();
}
