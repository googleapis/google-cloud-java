/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// DO NOT EDIT! This is a generated sample ("Request",  "language_syntax_text")
// sample-metadata:
//   title: Analyzing Syntax
//   description: Analyzing Syntax in a String
//   usage: gradle run -PmainClass=com.google.cloud.examples.language.v1.LanguageSyntaxText [--args='[--text_content "This is a short sentence."]']

package com.google.cloud.examples.language.v1;

import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.DependencyEdge;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.PartOfSpeech;
import com.google.cloud.language.v1.TextSpan;
import com.google.cloud.language.v1.Token;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class LanguageSyntaxText {
  // [START language_syntax_text]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
   * import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
   * import com.google.cloud.language.v1.DependencyEdge;
   * import com.google.cloud.language.v1.Document;
   * import com.google.cloud.language.v1.EncodingType;
   * import com.google.cloud.language.v1.LanguageServiceClient;
   * import com.google.cloud.language.v1.PartOfSpeech;
   * import com.google.cloud.language.v1.TextSpan;
   * import com.google.cloud.language.v1.Token;
   */

  /**
   * Analyzing Syntax in a String
   *
   * @param textContent The text content to analyze
   */
  public static void sampleAnalyzeSyntax(String textContent) {
    try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
      // textContent = "This is a short sentence.";

      // Available types: PLAIN_TEXT, HTML
      Document.Type type = Document.Type.PLAIN_TEXT;

      // Optional. If not specified, the language is automatically detected.
      // For list of supported languages:
      // https://cloud.google.com/natural-language/docs/languages
      String language = "en";
      Document document =
          Document.newBuilder().setContent(textContent).setType(type).setLanguage(language).build();

      // Available values: NONE, UTF8, UTF16, UTF32
      EncodingType encodingType = EncodingType.UTF8;
      AnalyzeSyntaxRequest request =
          AnalyzeSyntaxRequest.newBuilder()
              .setDocument(document)
              .setEncodingType(encodingType)
              .build();
      AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(request);
      // Loop through tokens returned from the API
      for (Token token : response.getTokensList()) {
        // Get the text content of this token. Usually a word or punctuation.
        TextSpan text = token.getText();
        System.out.printf("Token text: %s\n", text.getContent());
        System.out.printf(
            "Location of this token in overall document: %s\n", text.getBeginOffset());
        // Get the part of speech information for this token.
        // Parts of spech are as defined in:
        // http://www.lrec-conf.org/proceedings/lrec2012/pdf/274_Paper.pdf
        PartOfSpeech partOfSpeech = token.getPartOfSpeech();
        // Get the tag, e.g. NOUN, ADJ for Adjective, et al.
        System.out.printf("Part of Speech tag: %s\n", partOfSpeech.getTag());
        // Get the voice, e.g. ACTIVE or PASSIVE
        System.out.printf("Voice: %s\n", partOfSpeech.getVoice());
        // Get the tense, e.g. PAST, FUTURE, PRESENT, et al.
        System.out.printf("Tense: %s\n", partOfSpeech.getTense());
        // See API reference for additional Part of Speech information available
        // Get the lemma of the token. Wikipedia lemma description
        // https://en.wikipedia.org/wiki/Lemma_(morphology)
        System.out.printf("Lemma: %s\n", token.getLemma());
        // Get the dependency tree parse information for this token.
        // For more information on dependency labels:
        // http://www.aclweb.org/anthology/P13-2017
        DependencyEdge dependencyEdge = token.getDependencyEdge();
        System.out.printf("Head token index: %s\n", dependencyEdge.getHeadTokenIndex());
        System.out.printf("Label: %s\n", dependencyEdge.getLabel());
      }
      // Get the language of the text, which will be the same as
      // the language specified in the request or, if not specified,
      // the automatically-detected language.
      System.out.printf("Language of the text: %s\n", response.getLanguage());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END language_syntax_text]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("text_content").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String textContent = cl.getOptionValue("text_content", "This is a short sentence.");

    sampleAnalyzeSyntax(textContent);
  }
}
