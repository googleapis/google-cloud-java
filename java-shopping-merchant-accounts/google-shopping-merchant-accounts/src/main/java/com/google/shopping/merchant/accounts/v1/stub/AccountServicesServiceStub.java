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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.AccountServicesServiceClient.ListAccountServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.AccountService;
import com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse;
import com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccountServicesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccountServicesServiceStub implements BackgroundResource {

  public UnaryCallable<GetAccountServiceRequest, AccountService> getAccountServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccountServiceCallable()");
  }

  public UnaryCallable<ListAccountServicesRequest, ListAccountServicesPagedResponse>
      listAccountServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountServicesPagedCallable()");
  }

  public UnaryCallable<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountServicesCallable()");
  }

  public UnaryCallable<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: proposeAccountServiceCallable()");
  }

  public UnaryCallable<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: approveAccountServiceCallable()");
  }

  public UnaryCallable<RejectAccountServiceRequest, Empty> rejectAccountServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: rejectAccountServiceCallable()");
  }

  @Override
  public abstract void close();
}
