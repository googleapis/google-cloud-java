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

public final class PipelineExecuteOptions extends AbstractOptions<PipelineExecuteOptions> {

  public PipelineExecuteOptions() {
    super(InternalOptions.EMPTY);
  }

  PipelineExecuteOptions(InternalOptions options) {
    super(options);
  }

  @Override
  PipelineExecuteOptions self(InternalOptions options) {
    return new PipelineExecuteOptions(options);
  }

  public PipelineExecuteOptions withExplainOptions(ExplainOptions options) {
    return with("explain_options", options);
  }

  public PipelineExecuteOptions withIndexMode(String indexMode) {
    return with("index_mode", indexMode);
  }
}
