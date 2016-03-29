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
 * Implementation of this interface can persist their state and restore from it.
 *
 * <p>
 * A typical capture usage:
 * <pre> {@code
 * X restorableObj; // X instanceof Restorable<X>
 * RestorableState<X> state = restorableObj.capture();
 * .. persist state
 * }</pre>
 *
 * A typical restore usage:
 * <pre> {@code
 * RestorableState<X> state = ... // read from persistence
 * X restorableObj = state.restore();
 * ...
 * }</pre>
 *
 * @param <T> the restorable object's type
 */
public interface Restorable<T extends Restorable<T>> {

  /**
   * Captures the state of this object.
   *
   * @return a {@link RestorableState} instance that contains the state for this object and can
   *     restore it afterwards.
   */
  RestorableState<T> capture();
}
