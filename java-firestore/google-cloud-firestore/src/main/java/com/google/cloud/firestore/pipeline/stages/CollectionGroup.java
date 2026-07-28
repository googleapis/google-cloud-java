/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.pipeline.stages;

import static com.google.cloud.firestore.PipelineUtils.encodeValue;

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Value;

@InternalApi
public final class CollectionGroup extends Stage {

  private final String collectionId;

  @InternalApi
  public CollectionGroup(String collectionId, CollectionGroupOptions options) {
    super("collection_group", options.options);
    this.collectionId = collectionId;
  }

  public CollectionGroup withOptions(CollectionGroupOptions options) {
    return new CollectionGroup(collectionId, options);
  }

  @Override
  Iterable<Value> toStageArgs() {
    return ImmutableList.of(
        Value.newBuilder().setReferenceValue("").build(), encodeValue(collectionId));
  }
}
