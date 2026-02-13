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
package com.google.cloud.datastore.execution.request;

import com.google.api.core.InternalApi;

/**
 * An internal functional interface whose implementation has the responsibility to populate a Proto
 * object from a domain object.
 *
 * @param <INPUT> the type of domain object.
 * @param <OUTPUT> the type of proto object
 */
@InternalApi
public interface ProtoPreparer<INPUT, OUTPUT> {
  OUTPUT prepare(INPUT input);
}
