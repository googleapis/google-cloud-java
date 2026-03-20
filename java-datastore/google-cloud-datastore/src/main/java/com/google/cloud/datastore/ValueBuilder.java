/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.GcpLaunchStage;

/**
 * A common interface for Value builders.
 *
 * @param <V> the data type that the {@code Value} object holds.
 * @param <P> the value type.
 * @param <B> the value type's associated builder.
 */
@InternalExtensionOnly
public interface ValueBuilder<V, P extends Value<V>, B extends ValueBuilder<V, P, B>> {

  ValueType getValueType();

  B mergeFrom(P other);

  boolean getExcludeFromIndexes();

  B setExcludeFromIndexes(boolean excludeFromIndexes);

  /** Deprecated. This library preserves the field for backwards compatibility. */
  @GcpLaunchStage.Deprecated
  int getMeaning();

  /** Deprecated. This library preserves the field for backwards compatibility. */
  @GcpLaunchStage.Deprecated
  B setMeaning(int meaning);

  V get();

  B set(V value);

  P build();
}
