/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal.compat;

import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.RowAdapter;
import com.google.cloud.bigtable.data.v2.models.RowMutation;

public class DisabledShim implements Shim {

  @Override
  public void close() {}

  @Override
  public <RowT> UnaryCallable<Query, RowT> decorateReadRow(
      UnaryCallable<Query, RowT> classic,
      RowAdapter<RowT> rowAdapter,
      UnaryCallSettings<?, ?> settings) {
    return classic;
  }

  @Override
  public UnaryCallable<RowMutation, Void> decorateMutateRow(
      UnaryCallable<RowMutation, Void> classic, UnaryCallSettings<?, ?> settings) {
    return classic;
  }
}
