/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.billing.budgets.v1.stub;

import static com.google.cloud.billing.budgets.v1.BudgetServiceClient.ListBudgetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.budgets.v1.Budget;
import com.google.cloud.billing.budgets.v1.CreateBudgetRequest;
import com.google.cloud.billing.budgets.v1.DeleteBudgetRequest;
import com.google.cloud.billing.budgets.v1.GetBudgetRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsRequest;
import com.google.cloud.billing.budgets.v1.ListBudgetsResponse;
import com.google.cloud.billing.budgets.v1.UpdateBudgetRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BudgetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BudgetServiceStub implements BackgroundResource {

  public UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable() {
    throw new UnsupportedOperationException("Not implemented: createBudgetCallable()");
  }

  public UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBudgetCallable()");
  }

  public UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable() {
    throw new UnsupportedOperationException("Not implemented: getBudgetCallable()");
  }

  public UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse> listBudgetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBudgetsPagedCallable()");
  }

  public UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBudgetsCallable()");
  }

  public UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBudgetCallable()");
  }

  @Override
  public abstract void close();
}
