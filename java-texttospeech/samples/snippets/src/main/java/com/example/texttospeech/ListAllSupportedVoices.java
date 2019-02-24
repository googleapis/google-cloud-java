/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.texttospeech;

// Imports the Google Cloud client library
import com.google.cloud.texttospeech.v1.ListVoicesRequest;
import com.google.cloud.texttospeech.v1.ListVoicesResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.Voice;
import com.google.protobuf.ByteString;

import java.util.List;


/**
 * Google Cloud TextToSpeech API sample application.
 * Example usage: mvn package exec:java
 *                    -Dexec.mainClass='com.example.texttospeech.ListAllSupportedVoices'
 */
public class ListAllSupportedVoices {

  // [START tts_list_voices]
  /**
   * Demonstrates using the Text to Speech client to list the client's supported voices.
   * @throws Exception on TextToSpeechClient Errors.
   */
  public static List<Voice> listAllSupportedVoices() throws Exception {
    // Instantiates a client
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      // Builds the text to speech list voices request
      ListVoicesRequest request = ListVoicesRequest.getDefaultInstance();

      // Performs the list voices request
      ListVoicesResponse response = textToSpeechClient.listVoices(request);
      List<Voice> voices = response.getVoicesList();

      for (Voice voice : voices) {
        // Display the voice's name. Example: tpc-vocoded
        System.out.format("Name: %s\n", voice.getName());

        // Display the supported language codes for this voice. Example: "en-us"
        List<ByteString> languageCodes = voice.getLanguageCodesList().asByteStringList();
        for (ByteString languageCode : languageCodes) {
          System.out.format("Supported Language: %s\n", languageCode.toStringUtf8());
        }

        // Display the SSML Voice Gender
        System.out.format("SSML Voice Gender: %s\n", voice.getSsmlGender());

        // Display the natural sample rate hertz for this voice. Example: 24000
        System.out.format("Natural Sample Rate Hertz: %s\n\n",
            voice.getNaturalSampleRateHertz());
      }
      return voices;
    }
  }
  // [END tts_list_voices]
}