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
/**
 * Mediates message flow between two {@link com.google.api.gax.rpc.ResponseObserver}s.
 *
 * <p>It is intended for situations when a stream needs to be transformed in such a way where the
 * incoming responses do not map 1:1 to the output responses. This is used to transform
 * ReadRowsResponse chunks into logical rows, but is generic enough to be used for other purposes.
 *
 * <p>For internal use, public for technical reasons.
 */
@InternalApi
package com.google.cloud.bigtable.gaxx.reframing;

import com.google.api.core.InternalApi;
