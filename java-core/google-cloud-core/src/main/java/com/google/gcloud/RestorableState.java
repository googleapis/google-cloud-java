/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud;

/**
 * A common interface for restorable states. Implementations of {@code RestorableState} are capable
 * of saving the state of an object to restore it for later use.
 *
 * Implementations of this class must implement {@link java.io.Serializable} to ensure that the
 * state of a the object can be correctly serialized.
 *
 * @param <T> the restored object's type
 */
public interface RestorableState<T extends Restorable<T>> {

  /**
   * Returns an object whose internal state reflects the one saved in the invocation object.
   */
  T restore();
}
