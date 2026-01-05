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

public final class CollectionOptions extends AbstractOptions<CollectionOptions> {

  public CollectionOptions() {
    super(InternalOptions.EMPTY);
  }

  CollectionOptions(InternalOptions options) {
    super(options);
  }

  @Override
  CollectionOptions self(InternalOptions options) {
    return new CollectionOptions(options);
  }

  public CollectionOptions withHints(CollectionHints hints) {
    return adding(hints);
  }
}
