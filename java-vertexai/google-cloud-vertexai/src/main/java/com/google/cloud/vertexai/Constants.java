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

package com.google.cloud.vertexai;

/** A class that holds all constants for vertexai. */
public final class Constants {
  // Constants for VertexAI class
  public static final String USER_AGENT_HEADER = "model-builder";
  static final String DEFAULT_LOCATION = "us-central1";
  static final String GOOGLE_CLOUD_REGION = "GOOGLE_CLOUD_REGION";
  static final String CLOUD_ML_REGION = "CLOUD_ML_REGION";
  static final String GOOGLE_CLOUD_PROJECT = "GOOGLE_CLOUD_PROJECT";

  // trivial change
  private Constants() {}
}
