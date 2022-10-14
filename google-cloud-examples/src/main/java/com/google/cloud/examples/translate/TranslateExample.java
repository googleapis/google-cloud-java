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

package com.google.cloud.examples.translate;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An example of using Google Translation.
 *
 * <p>This example demonstrates a simple/typical Translation usage.
 *
 * <p>See the <a
 * href="https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 *
 * <pre>{@code target/appassembler/bin/TranslateExample
 *  -Dexec.args="[[<apiKey>] <targetLanguage>]
 *  list languages <languageCode>?
 *  detect <text>+
 *  translate <text>+"}</pre>
 *
 * <p>The first parameter is an optional {@code targetLanguage}. If the target language is not
 * supplied, {@code en} is used (see {@link
 * com.google.cloud.translate.TranslateOptions.Builder#setTargetLanguage(String)}).
 */
public class TranslateExample {

  private static final Map<String, TranslateAction> ACTIONS = new HashMap<>();

  private abstract static class TranslateAction<T> {

    abstract void run(Translate translate, T arg) throws Exception;

    abstract T parse(String... args) throws Exception;

    protected String params() {
      return "";
    }
  }

  /**
   * This class demonstrates how to list supported languages.
   *
   * @see <a href="https://cloud.google.com/translate/v2/discovering-supported-languages-with-rest">
   *     Discovering Supported Languages</a>
   */
  private static class ListLanguagesAction extends TranslateAction<Void> {
    @Override
    public void run(Translate translate, Void arg) {
      List<Language> languages = translate.listSupportedLanguages();
      System.out.println("Supported languages:");
      for (Language language : languages) {
        System.out.println(language);
      }
    }

    @Override
    Void parse(String... args) throws Exception {
      if (args.length == 0) {
        return null;
      }
      throw new IllegalArgumentException("This action takes no arguments.");
    }
  }

  /**
   * This class demonstrates how detect the language of some texts.
   *
   * @see <a href="https://cloud.google.com/translate/v2/detecting-language-with-rest">Detecting
   *     Language</a>
   */
  private static class DetectLanguageAction extends TranslateAction<List<String>> {
    @Override
    public void run(Translate translate, List<String> texts) {
      List<Detection> detections = translate.detect(texts);
      if (texts.size() == 1) {
        System.out.println("Detected language is:");
      } else {
        System.out.println("Detected languages are:");
      }
      for (Detection detection : detections) {
        System.out.println(detection);
      }
    }

    @Override
    List<String> parse(String... args) throws Exception {
      if (args.length >= 1) {
        return Arrays.asList(args);
      } else {
        throw new IllegalArgumentException("Missing required texts.");
      }
    }

    @Override
    public String params() {
      return "<text>+";
    }
  }

  /**
   * This class demonstrates how to translate some texts.
   *
   * @see <a href="https://cloud.google.com/translate/v2/translating-text-with-rest">Translating
   *     Text</a>
   */
  private static class TranslateTextAction extends TranslateAction<List<String>> {
    @Override
    public void run(Translate translate, List<String> texts) {
      List<Translation> translations = translate.translate(texts);
      if (texts.size() == 1) {
        System.out.println("Translation is:");
      } else {
        System.out.println("Translations are:");
      }
      for (Translation translation : translations) {
        System.out.println(translation);
      }
    }

    @Override
    List<String> parse(String... args) throws Exception {
      if (args.length >= 1) {
        return Arrays.asList(args);
      } else {
        throw new IllegalArgumentException("Missing required texts.");
      }
    }

    @Override
    public String params() {
      return "<text>+";
    }
  }

  static {
    ACTIONS.put("languages", new ListLanguagesAction());
    ACTIONS.put("detect", new DetectLanguageAction());
    ACTIONS.put("translate", new TranslateTextAction());
  }

  private static void printUsage() {
    StringBuilder actionAndParams = new StringBuilder();
    for (Map.Entry<String, TranslateAction> entry : ACTIONS.entrySet()) {
      actionAndParams.append(System.lineSeparator()).append('\t').append(entry.getKey());
      String param = entry.getValue().params();
      if (param != null && !param.isEmpty()) {
        actionAndParams.append(' ').append(param);
      }
    }
    System.out.printf(
        "Usage: %s [[<apiKey>] <targetLanguage>] operation <args>*%s%n",
        TranslateExample.class.getSimpleName(), actionAndParams);
  }

  @SuppressWarnings("unchecked")
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Missing required action");
      printUsage();
      return;
    }
    TranslateOptions.Builder optionsBuilder = TranslateOptions.newBuilder();
    TranslateAction action;
    String actionName;
    if (args.length >= 3 && !ACTIONS.containsKey(args[1])) {
      optionsBuilder.setApiKey(args[0]);
      actionName = args[2];
      optionsBuilder.setTargetLanguage(args[1]);
      args = Arrays.copyOfRange(args, 3, args.length);
    } else if (args.length >= 2 && !ACTIONS.containsKey(args[0])) {
      optionsBuilder.setTargetLanguage(args[0]);
      actionName = args[1];
      args = Arrays.copyOfRange(args, 2, args.length);
    } else {
      actionName = args[0];
      args = Arrays.copyOfRange(args, 1, args.length);
    }
    action = ACTIONS.get(actionName);
    if (action == null) {
      System.out.println("Unrecognized action.");
      printUsage();
      return;
    }
    Object arg;
    try {
      arg = action.parse(args);
    } catch (IllegalArgumentException ex) {
      System.out.printf("Invalid input for action '%s'. %s%n", actionName, ex.getMessage());
      System.out.printf("Expected: %s%n", action.params());
      return;
    } catch (Exception ex) {
      System.out.println("Failed to parse arguments.");
      ex.printStackTrace();
      return;
    }
    Translate translate = optionsBuilder.build().getService();
    action.run(translate, arg);
  }
}
