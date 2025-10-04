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

import static com.google.shopping.merchant.accounts.v1.AccountRelationshipsServiceClient.ListAccountRelationshipsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.merchant.accounts.v1.AccountRelationship;
import com.google.shopping.merchant.accounts.v1.GetAccountRelationshipRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountRelationshipsResponse;
import com.google.shopping.merchant.accounts.v1.UpdateAccountRelationshipRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccountRelationshipsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccountRelationshipsServiceStub implements BackgroundResource {

  public UnaryCallable<GetAccountRelationshipRequest, AccountRelationship>
      getAccountRelationshipCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccountRelationshipCallable()");
  }

  public UnaryCallable<UpdateAccountRelationshipRequest, AccountRelationship>
      updateAccountRelationshipCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccountRelationshipCallable()");
  }

  public UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsPagedResponse>
      listAccountRelationshipsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAccountRelationshipsPagedCallable()");
  }

  public UnaryCallable<ListAccountRelationshipsRequest, ListAccountRelationshipsResponse>
      listAccountRelationshipsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountRelationshipsCallable()");
  }

  @Override
  public abstract void close();
}
