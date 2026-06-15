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

import com.google.cloud.firestore.pipeline.expressions.Field;

public final class RawOptions extends AbstractOptions<RawOptions> {

  public RawOptions() {
    this(InternalOptions.EMPTY);
  }

  public static RawOptions of(String key, String value) {
    return new RawOptions(InternalOptions.of(key, encodeValue(value)));
  }

  public static RawOptions of(String key, boolean value) {
    return new RawOptions(InternalOptions.of(key, encodeValue(value)));
  }

  public static RawOptions of(String key, long value) {
    return new RawOptions(InternalOptions.of(key, encodeValue(value)));
  }

  public static RawOptions of(String key, double value) {
    return new RawOptions(InternalOptions.of(key, encodeValue(value)));
  }

  public static RawOptions of(String key, Field value) {
    return new RawOptions(InternalOptions.of(key, value.toProto()));
  }

  RawOptions(InternalOptions options) {
    super(options);
  }

  @Override
  protected RawOptions self(InternalOptions options) {
    return new RawOptions(options);
  }
}
