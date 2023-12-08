/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.vertexai.generativeai.preview;

import com.google.cloud.vertexai.v1beta1.Content;
import com.google.cloud.vertexai.v1beta1.Part;

/** Helper class to create content. */
public class ContentMaker {

  private ContentMaker() {}

  /** Create a content from a string, assumimg the role is user. */
  public static Content fromString(String text) {
    return Content.newBuilder().addParts(Part.newBuilder().setText(text)).setRole("user").build();
  }

  /** Create a content from a string and role. */
  public static Content fromString(String role, String text) {
    return Content.newBuilder().addParts(Part.newBuilder().setText(text)).setRole(role).build();
  }

  /** TODO: add helper function to convert a list of string and images to a single turn content. */
}
