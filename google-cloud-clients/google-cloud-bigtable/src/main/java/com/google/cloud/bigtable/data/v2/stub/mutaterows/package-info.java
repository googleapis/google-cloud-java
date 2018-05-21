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
 * com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub#bulkMutateRowsCallable()}.
 *
 * <p>The implementation adapts gax's {@link com.google.api.gax.rpc.BatchingCallable} to work with
 * Bigtable's MutateRows RPC. There are 3 customizations that are necessary:
 *
 * <ul>
 *   <li>BulkMutationsUserFacingCallable: Wraps request and response protobufs.
 *   <li>BulkMutationsSpoolingCallable: The Bigtable protocol streams results from the mutations as
 *       they are applied. However gax's {@link com.google.api.gax.rpc.BatchingCallable} is designed
 *       for {@link com.google.api.gax.rpc.UnaryCallable}s. This adapter spools the responses and
 *       presents the results as if they came from a {@link com.google.api.gax.rpc.UnaryCallable}.
 *   <li>BulkMutateRowsBatchingDescriptor: Each entry can fail independently from the overall
 *       request. The descriptor splits the results for each entry and notifies the responsible
 *       issuer.
 * </ul>
 *
 * <p>This package is considered an internal implementation detail and is not meant to be used by
 * applications directly.
 */
package com.google.cloud.bigtable.data.v2.stub.mutaterows;
