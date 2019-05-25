/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.translate.spi.v2;

import com.google.api.services.translate.model.DetectionsResourceItems;
import com.google.api.services.translate.model.LanguagesResource;
import com.google.api.services.translate.model.TranslationsResource;
import com.google.cloud.ServiceRpc;
import java.util.List;
import java.util.Map;

public interface TranslateRpc extends ServiceRpc {

  enum Option {
    SOURCE_LANGUAGE("source"),
    TARGET_LANGUAGE("target"),
    MODEL("model"),
    FORMAT("format");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    String getString(Map<Option, ?> options) {
      return get(options);
    }
  }

  /**
   * Returns a list of the languages supported by Google Translation.
   *
   * @param optionMap options to listing language translations
   */
  List<LanguagesResource> listSupportedLanguages(Map<Option, ?> optionMap);

  /**
   * Detects the language of the provided texts.
   *
   * @param texts the texts to translate
   * @return a list of lists of detections, one list of detections for each provided text, in order
   */
  List<List<DetectionsResourceItems>> detect(List<String> texts);

  /**
   * Translates the provided texts.
   *
   * @param texts the texts to translate
   * @param optionMap options to text translation
   * @return a list of resources containing translation information, in the same order of the
   *     provided texts
   */
  List<TranslationsResource> translate(List<String> texts, Map<Option, ?> optionMap);
}
