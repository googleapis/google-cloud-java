/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.AccountsServiceClient.ListChildAccountsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.css.v1.Account;
import com.google.shopping.css.v1.GetAccountRequest;
import com.google.shopping.css.v1.ListChildAccountsRequest;
import com.google.shopping.css.v1.ListChildAccountsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelsRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccountsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccountsServiceStub implements BackgroundResource {

  public UnaryCallable<ListChildAccountsRequest, ListChildAccountsPagedResponse>
      listChildAccountsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listChildAccountsPagedCallable()");
  }

  public UnaryCallable<ListChildAccountsRequest, ListChildAccountsResponse>
      listChildAccountsCallable() {
    throw new UnsupportedOperationException("Not implemented: listChildAccountsCallable()");
  }

  public UnaryCallable<GetAccountRequest, Account> getAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccountCallable()");
  }

  public UnaryCallable<UpdateAccountLabelsRequest, Account> updateLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLabelsCallable()");
  }

  @Override
  public abstract void close();
}
