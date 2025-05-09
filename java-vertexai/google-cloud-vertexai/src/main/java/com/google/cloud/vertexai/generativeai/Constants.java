/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai.generativeai;

import com.google.common.collect.ImmutableSet;

/** A class that holds all constants for vertexai/generativeai. */
public final class Constants {
  public static final String MODEL_NAME_PREFIX_PROJECTS = "projects/";
  public static final String MODEL_NAME_PREFIX_PUBLISHERS = "publishers/";
  public static final String MODEL_NAME_PREFIX_MODELS = "models/";
  public static final ImmutableSet<String> MODEL_NAME_PREFIXES =
      ImmutableSet.of(
          MODEL_NAME_PREFIX_PROJECTS, MODEL_NAME_PREFIX_PUBLISHERS, MODEL_NAME_PREFIX_MODELS);

  private Constants() {}
}
