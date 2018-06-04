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
 * Implementation details for {@link
 * com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub#readRowsCallable()}.
 *
 * <p>The ReadRows protocol is optimized for transmission and is not designed to be consumed
 * directly. This package implements significant customizations on top of the raw GAPIC generated
 * stub to handle row merging and retries.
 *
 * <ul>
 *   <li>ReadRowsUserCallable: Creates protobuf {@link com.google.bigtable.v2.ReadRowsRequest}s from
 *       user facing wrappers.
 *   <li>RowMergingCallable (+ helpers): Implements a state machine that merges chunks into logical
 *       rows. The logical row representation is configurable via a RowAdapter. Please note that
 *       this will also emit special marker rows that help with retries in the next stage, but need
 *       to be filtered out.
 *   <li>RowMerger (+ helpers): Implements resuming retries for gax's Callables#retrying middleware.
 *   <li>FilterMarkerRowsCallable: Filters out marker rows that are used for efficient retry
 *       resumes. The marker is an internal implementation detail to communicate state to the
 *       RowMerger and should not be exposed to the caller.
 * </ul>
 *
 * <p>This package is considered an internal implementation detail and is not meant to be used by
 * applications directly.
 */
package com.google.cloud.bigtable.data.v2.stub.readrows;
