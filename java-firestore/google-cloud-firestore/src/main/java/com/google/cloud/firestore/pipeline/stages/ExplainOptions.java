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

import com.google.cloud.firestore.PipelineUtils;
import com.google.firestore.v1.Value;

public final class ExplainOptions extends AbstractOptions<ExplainOptions> {

  public static class ExecutionMode {
    public static final ExecutionMode EXPLAIN = new ExecutionMode("explain");
    public static final ExecutionMode ANALYZE = new ExecutionMode("analyze");

    private final Value value;

    private ExecutionMode(String format) {
      this.value = PipelineUtils.encodeValue(format);
    }

    public Value toProto() {
      return value;
    }
  }

  public ExplainOptions() {
    super(InternalOptions.EMPTY);
  }

  ExplainOptions(InternalOptions options) {
    super(options);
  }

  @Override
  ExplainOptions self(InternalOptions options) {
    return new ExplainOptions(options);
  }

  public ExplainOptions withExecutionMode(ExecutionMode mode) {
    return with("mode", mode.toProto());
  }
}
