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

package com.google.cloud.translate;

import com.google.cloud.Service;
import com.google.cloud.translate.spi.v2.TranslateRpc;

import java.util.List;

/**
 * An interface for Google Translation.
 *
 * @see <a href="https://cloud.google.com/translate/docs">Google Translation</a>
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
     * returned by {@link TranslateOptions#getTargetLanguage()} is used. When provided, the returned
     * {@link Language#getName()} will be in the language specified by the {@code targetLanguage}
     * code.
     *
     * @param targetLanguage the target language code
     */
    public static LanguageListOption targetLanguage(String targetLanguage) {
      return new LanguageListOption(TranslateRpc.Option.TARGET_LANGUAGE, targetLanguage);
    }
  }

  /**
   * Class for specifying translate options.
   */
  class TranslateOption extends Option {

    private static final long serialVersionUID = 1347871763933507106L;

    private TranslateOption(TranslateRpc.Option rpcOption, String value) {
      super(rpcOption, value);
    }

    /**
     * Returns an option for setting the source language. If not provided, Google Translation will try
     * to detect the language of the text to translate.
     *
     * @param sourceLanguage the source language code
     */
    public static TranslateOption sourceLanguage(String sourceLanguage) {
      return new TranslateOption(TranslateRpc.Option.SOURCE_LANGUAGE, sourceLanguage);
    }

    /**
     * Returns an option for setting the target language. If this option is not provided, the value
     * returned by {@link TranslateOptions#getTargetLanguage()} is used.
     *
     * @param targetLanguage the target language code
     */
    public static TranslateOption targetLanguage(String targetLanguage) {
      return new TranslateOption(TranslateRpc.Option.TARGET_LANGUAGE, targetLanguage);
    }

    /**
     * Sets the language translation model. You can use this parameter to take advantage of Neural
     * Machine Translation. Possible values are {@code base} and {@code nmt}. Google Translation could
     * use a different model to translate your text: use {@link Translation#getModel()} to know
     * which model was used for translation. Please note that you must be whitelisted to use this
     * option, otherwise translation will fail.
     *
     * @param model the language translation model
     */
    public static TranslateOption model(String model) {
      return new TranslateOption(TranslateRpc.Option.MODEL, model);
    }

    /**
     * Sets the format of the source text, in either HTML (default) or plain-text.
     * A value of {@code html} indicates HTML and a value of {@code text} indicates plain-text.
     *
     * @param format the format of the source text
     */
    public static TranslateOption format(String format) {
      return new TranslateOption(TranslateRpc.Option.FORMAT, format);
    }
  }

  /**
   * Returns the list of languages supported by Google Translation. If an option from
   * {@link LanguageListOption#targetLanguage(String)} is provided, the value of
   * {@link Language#getName()} is localized according to the provided target language. If no such
   * option is passed, the value of {@link Language#getName()} is localized according to
   * {@link TranslateOptions#getTargetLanguage()}.
   *
   * <p>Example of listing supported languages, localized according to
   * {@link TranslateOptions#getTargetLanguage()}:
   * <pre> {@code
   * List<Language> languages = translate.listSupportedLanguages();
   * }</pre>
   *
   * <p>Example of listing supported languages, localized according to a provided language:
   * <pre> {@code
   * List<Language> languages = translate.listSupportedLanguages(
   *     LanguageListOption.targetLanguage("es"));
   * }</pre>
   *
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
   *     provided text, in order
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
   *     provided text, in order
   */
  List<Detection> detect(String... texts);

  /**
   * Detects the language of the provided text. Returns an object containing information on the
   * language detection.
   *
   * <p>Example of detecting the language of a text:
   * <pre> {@code
   * Detection detection = translate.detect("Hello, World!");
   * }</pre>
   *
   */
  Detection detect(String text);

  /**
   * Translates the provided texts.
   *
   * <p>Example of translating some texts:
   * <pre> {@code
   * List<String> texts = new LinkedList<>();
   * texts.add("Hello, World!");
   * texts.add("¡Hola Mundo!");
   * List<Translation> translations = translate.translate(texts);
   * }</pre>
   *
   * <p>Example of translating some texts, specifying source and target language:
   * <pre> {@code
   * List<String> texts = new LinkedList<>();
   * texts.add("¡Hola Mundo!");
   * List<Translation> translations = translate.translate(texts,
   *     TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("de"));
   * }</pre>
   *
   * @param texts the texts to translate
   * @return a list of objects containing information on the language translation, one for each
   *     provided text, in order
   * @throws TranslateException upon failure or if {@link TranslateOption#model(String)} is used by
   *     a non-whitelisted user
   */
  List<Translation> translate(List<String> texts, TranslateOption... options);

  /**
   * Translates the provided texts.
   *
   * <p>Example of translating a text:
   * <pre> {@code
   * Translation translation = translate.translate("¡Hola Mundo!");
   * }</pre>
   *
   * <p>Example of translating a text, specifying source and target language:
   * <pre> {@code
   * Translation translation = translate.translate("¡Hola Mundo!",
   *     TranslateOption.sourceLanguage("es"), TranslateOption.targetLanguage("de"));
   * }</pre>
   *
   * @param text the text to translate
   * @return an object containing information on the language translation
   * @throws TranslateException upon failure or if {@link TranslateOption#model(String)} is used by
   *     a non-whitelisted user
   */
  Translation translate(String text, TranslateOption... options);
}
