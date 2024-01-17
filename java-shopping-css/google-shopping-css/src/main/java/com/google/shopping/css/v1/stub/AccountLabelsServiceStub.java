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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.AccountLabelsServiceClient.ListAccountLabelsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.AccountLabel;
import com.google.shopping.css.v1.CreateAccountLabelRequest;
import com.google.shopping.css.v1.DeleteAccountLabelRequest;
import com.google.shopping.css.v1.ListAccountLabelsRequest;
import com.google.shopping.css.v1.ListAccountLabelsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AccountLabelsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AccountLabelsServiceStub implements BackgroundResource {

  public UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsPagedResponse>
      listAccountLabelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountLabelsPagedCallable()");
  }

  public UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountLabelsCallable()");
  }

  public UnaryCallable<CreateAccountLabelRequest, AccountLabel> createAccountLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: createAccountLabelCallable()");
  }

  public UnaryCallable<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccountLabelCallable()");
  }

  public UnaryCallable<DeleteAccountLabelRequest, Empty> deleteAccountLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccountLabelCallable()");
  }

  @Override
  public abstract void close();
}
