/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

/**
 * Marker interface to signify an object which has start and stop lifecycle points.
 *
 * <p>This interface shouldn't be used outside of {@code com.google.cloud.storage.it.runner}. When
 * we have access to java modules this will be enforced.
 */
public interface ManagedLifecycle {

  Object get();

  void start();

  void stop();
}
