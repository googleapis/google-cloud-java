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
package com.google.cloud.datastore.execution;

import com.google.api.core.InternalApi;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.ReadOption;

/**
 * An internal functional interface whose implementation has the responsibility to execute a {@link
 * Query} and returns the result. This class will have the responsibility to orchestrate between
 * {@link com.google.cloud.datastore.execution.request.ProtoPreparer}, {@link
 * com.google.cloud.datastore.spi.v1.DatastoreRpc} and {@link
 * com.google.cloud.datastore.execution.response.ResponseTransformer} layers.
 *
 * @param <INPUT> A {@link Query} to execute.
 * @param <OUTPUT> the type of result produced by Query.
 */
@InternalApi
public interface QueryExecutor<INPUT extends Query<OUTPUT>, OUTPUT> {

  /**
   * @param query A {@link Query} to execute.
   * @param readOptions Optional {@link ReadOption}s to be used when executing {@link Query}.
   */
  OUTPUT execute(INPUT query, ReadOption... readOptions);
}
