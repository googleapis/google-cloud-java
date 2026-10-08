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

/** Tracks work-in-progress session-path features that are not yet enabled in production. */
public final class WipFeatures {
  // Enable session-path diversion for CheckAndMutateRow once per-method diversion is supported.
  public static final boolean CHECK_AND_MUTATE_ROW_ENABLED = false;

  // Enable session-path diversion for ReadModifyWriteRow once per-method diversion is supported.
  public static final boolean READ_MODIFY_WRITE_ROW_ENABLED = false;

  private WipFeatures() {}
}
