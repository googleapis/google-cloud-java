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

import static com.google.shopping.merchant.accounts.v1.AccountsServiceClient.ListAccountsPagedResponse;
import static com.google.shopping.merchant.accounts.v1.AccountsServiceClient.ListSubAccountsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.Account;
import com.google.shopping.merchant.accounts.v1.CreateAndConfigureAccountRequest;
import com.google.shopping.merchant.accounts.v1.DeleteAccountRequest;
import com.google.shopping.merchant.accounts.v1.GetAccountRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountsRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountsResponse;
import com.google.shopping.merchant.accounts.v1.ListSubAccountsRequest;
import com.google.shopping.merchant.accounts.v1.ListSubAccountsResponse;
import com.google.shopping.merchant.accounts.v1.UpdateAccountRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccountsServiceStub implements BackgroundResource {

  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccountCallable()");
  }

  public UnaryCallable<CreateAndConfigureAccountRequest, Account>
      createAndConfigureAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: createAndConfigureAccountCallable()");
  }

  public UnaryCallable<DeleteAccountRequest, Empty> deleteAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccountCallable()");
  }

  public UnaryCallable<UpdateAccountRequest, Account> updateAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccountCallable()");
  }

  public UnaryCallable<ListAccountsRequest, ListAccountsPagedResponse> listAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountsPagedCallable()");
  }

  public UnaryCallable<ListAccountsRequest, ListAccountsResponse> listAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountsCallable()");
  }

  public UnaryCallable<ListSubAccountsRequest, ListSubAccountsPagedResponse>
      listSubAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubAccountsPagedCallable()");
  }

  public UnaryCallable<ListSubAccountsRequest, ListSubAccountsResponse> listSubAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSubAccountsCallable()");
  }

  @Override
  public abstract void close();
}
