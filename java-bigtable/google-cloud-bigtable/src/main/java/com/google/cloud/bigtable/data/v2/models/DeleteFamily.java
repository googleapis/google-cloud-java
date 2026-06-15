/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nonnull;

/** Representation of a DeleteFamily mod in a data change. */
@InternalApi("Intended for use by the BigtableIO in apache/beam only.")
@AutoValue
public abstract class DeleteFamily implements Entry, Serializable {
  private static final long serialVersionUID = 81806775917145615L;

  public static DeleteFamily create(@Nonnull String familyName) {
    return new AutoValue_DeleteFamily(familyName);
  }

  /** Get the column family of the current DeleteFamily. */
  @Nonnull
  public abstract String getFamilyName();
}
