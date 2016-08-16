/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.translate;

import com.google.cloud.Service;
import com.google.cloud.translate.spi.TranslateRpc;

import java.util.List;

/**
 * An interface for Google Translate.
 *
 * @see <a href="https://cloud.google.com/translate/docs">Google Translate</a>
 */
public interface Translate extends Service<TranslateOptions> {

  /**
   * Class for specifying supported language listing options.
   */
  class LanguageListOption extends Option {

    private static final long serialVersionUID = 1982978040516658597L;

    private LanguageListOption(TranslateRpc.Option rpcOption, String value) {
      super(rpcOption, value);
    }

    /**
     * Returns an option for setting the target language. If this option is not provided, the value
     * returned by {@link TranslateOptions#targetLanguage()} is used. When provided, the returned
     * {@link Language#name()} will be in the language specified by the {@code targetLanguage} code.
     *
     * @param targetLanguage the target language code
     */
    public static LanguageListOption targetLanguage(String targetLanguage) {
      return new LanguageListOption(TranslateRpc.Option.TARGET_LANGUAGE, targetLanguage);
    }
  }

  /**
   * Returns the list of languages supported by Google Translate. If
   * {@link LanguageListOption#targetLanguage(String)} is provided, {@link Language#name()} values
   * are localized according to the provided target language. If no such option is passed,
   * {@link Language#name()} values are localized according to
   * {@link TranslateOptions#targetLanguage()}.
   *
   * <p>Example of listing supported languages, localized according to
   * {@link TranslateOptions#targetLanguage()}:
   * <pre> {@code
   * List<Language> languages = translate.listSupportedLanguages();
   * }</pre>
   * Or according to another target language:
   * <pre> {@code
   * List<Language> languages = translate.listSupportedLanguages(
   *     LanguageListOption.targetLanguage("es"));
   * }</pre>
   */
  List<Language> listSupportedLanguages(LanguageListOption... options);

  /**
   * Detects the language of the provided texts.
   *
   * <p>Example of detecting the language of some texts:
   * <pre> {@code
   * List<String> texts = new LinkedList<>();
   * texts.add("Hello, World!");
   * texts.add("¡Hola Mundo!");
   * List<Detection> detections = translate.detect(texts);
   * }</pre>
   *
   * @param texts the texts for which language should be detected
   * @return a list of objects containing information on the language detection, one for each
   *     provided text, in order.
   */
  List<Detection> detect(List<String> texts);

  /**
   * Detects the language of the provided texts.
   *
   * <p>Example of detecting the language of some texts:
   * <pre> {@code
   * List<Detection> detections = translate.detect("Hello, World!", "¡Hola Mundo!");
   * }</pre>
   *
   * @param texts the texts for which language should be detected
   * @return a list of objects containing information on the language detection, one for each
   *     provided text, in order.
   */
  List<Detection> detect(String... texts);

  /**
   * Detects the language of the provided text. Returns an object containing information on the
   * language detection.
   *
   * <p>Example of detecting the language a text:
   * <pre> {@code
   * Detection detection = translate.detect("Hello, World!");
   * }</pre>
   */
  Detection detect(String text);
}
