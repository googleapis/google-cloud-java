/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.models;

import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/**
 * Miscellaneous helpers to validate input in the DSL.
 *
 * <p>Package-private for internal use.
 */
class Validations {
  private Validations() {}

  static void validateFamily(@Nonnull String name) {
    Preconditions.checkNotNull(name, "Family name can't be null");
    Preconditions.checkArgument(!name.isEmpty(), "Family name can't be empty");
  }

  static void validateTableId(@Nonnull String tableId) {
    Preconditions.checkNotNull(tableId, "tableId can't be null");
    Preconditions.checkArgument(!tableId.isEmpty(), "tableId can't be empty");
  }
}
