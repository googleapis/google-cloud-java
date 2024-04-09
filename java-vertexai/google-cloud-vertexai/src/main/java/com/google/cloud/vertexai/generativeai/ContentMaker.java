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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.Part;
import com.google.common.base.Strings;

/** Helper class to create content. */
public class ContentMaker {
  private static final String DEFAULT_ROLE = "user";

  /**
   * Creates a ContentMakerForRole for a given role.
   *
   * @param role Currently accepted role values are: "user", "model". No need to call forRole for
   *     the "user" role since it's the default role.
   */
  public static ContentMakerForRole forRole(String role) {
    return new ContentMakerForRole(role);
  }

  private static Content fromStringWithRole(String role, String text) {
    checkArgument(!Strings.isNullOrEmpty(text), "text message can't be null or empty.");
    return Content.newBuilder().addParts(Part.newBuilder().setText(text)).setRole(role).build();
  }

  private static Content fromMultiModalDataWithRole(String role, Object... multiModalData) {
    Content.Builder contentBuilder = Content.newBuilder().setRole(role);
    for (Object partData : multiModalData) {
      if (partData instanceof String) {
        String textData = (String) partData;
        contentBuilder.addParts(Part.newBuilder().setText(textData));
      } else if (partData instanceof Part) {
        contentBuilder.addParts((Part) partData);
      } else {
        throw new IllegalArgumentException("Unsupported data type: " + partData.getClass());
      }
    }
    return contentBuilder.build();
  }

  /**
   * Creates a content from a string, assuming the role is "user".
   *
   * <p>The resulting content will contain one single {@link com.google.cloud.vertexai.api.Part}
   * with its text field set.
   *
   * <p>To create a text content for "model", use `ContentMaker.forRole("model").fromString(text);
   */
  public static Content fromString(String text) {
    return fromStringWithRole(DEFAULT_ROLE, text);
  }

  /**
   * Creates a content from an array of Objects, assuming the role is "user".
   *
   * <p>The resulting content can contain multiple {@link com.google.cloud.vertexai.api.Part}s. Each
   * element in the array becomes one part.
   *
   * <p>To create a non-text modality content for any other
   *
   * @param multiModalData an array which contains the actual payload of each part. The element
   *     could be either a single String or a Part. When it's a single string, it's converted to a
   *     {@link com.google.cloud.vertexai.api.Part} that has the Text field set.
   */
  // TODO(b/333097480) Deprecate ContentMakerForRole
  public static Content fromMultiModalData(Object... multiModalData) {
    return fromMultiModalDataWithRole(DEFAULT_ROLE, multiModalData);
  }

  /**
   * Helper class to create content for a given role. Instantiated by ContentMaker.forRole("role").
   */
  public static class ContentMakerForRole {
    private String role;

    private ContentMakerForRole(String role) {
      this.role = role;
    }

    /**
     * Creates a content from a string.
     *
     * @param text a string which will be converted to a {@link com.google.cloud.vertexai.api.Part}
     *     with its text field set.
     */
    public Content fromString(String text) {
      return fromStringWithRole(role, text);
    }

    /**
     * Creates a content from an array of Objects.
     *
     * @param multiModalData an array which contains the actual payload of each part. The element
     *     could be either a single String or a Part. When it's a single string, it's converted to a
     *     {@link com.google.cloud.vertexai.api.Part} that has the Text field set.
     */
    public Content fromMultiModalData(Object... multiModalData) {
      return fromMultiModalDataWithRole(role, multiModalData);
    }
  }
}
