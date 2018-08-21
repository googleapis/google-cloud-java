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
import com.google.cloud.texttospeech.v1beta1.AudioConfig;
import com.google.cloud.texttospeech.v1beta1.AudioEncoding;
import com.google.cloud.texttospeech.v1beta1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1beta1.SynthesisInput;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1beta1.VoiceSelectionParams;
import com.google.protobuf.ByteString;

import java.io.FileOutputStream;
import java.io.OutputStream;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.MutuallyExclusiveGroup;
import net.sourceforge.argparse4j.inf.Namespace;

/**
 * Google Cloud TextToSpeech API sample application.
 * Example usage: mvn package exec:java-Dexec.mainClass='com.example.texttospeech.SynthesizeText'
 *                                     -Dexec.args='--text "hello"'
 */
public class SynthesizeText {

  // [START tts_synthesize_text]
  /**
   * Demonstrates using the Text to Speech client to synthesize text or ssml.
   *
   * @param text the raw text to be synthesized. (e.g., "Hello there!")
   * @throws Exception on TextToSpeechClient Errors.
   */
  public static void synthesizeText(String text) throws Exception {
    // Instantiates a client
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      // Set the text input to be synthesized
      SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

      // Build the voice request
      VoiceSelectionParams voice =
          VoiceSelectionParams.newBuilder()
              .setLanguageCode("en-US") // languageCode = "en_us"
              .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
              .build();

      // Select the type of audio file you want returned
      AudioConfig audioConfig =
          AudioConfig.newBuilder()
              .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
              .build();

      // Perform the text-to-speech request
      SynthesizeSpeechResponse response =
          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

      // Get the audio contents from the response
      ByteString audioContents = response.getAudioContent();

      // Write the response to the output file.
      try (OutputStream out = new FileOutputStream("output.mp3")) {
        out.write(audioContents.toByteArray());
        System.out.println("Audio content written to file \"output.mp3\"");
      }
    }
  }
  // [END tts_synthesize_text]

  // [START tts_synthesize_text_audio_profile_beta]
  /**
   * Demonstrates using the Text to Speech client with audio profiles to synthesize text or ssml
   *
   * @param text the raw text to be synthesized. (e.g., "Hello there!")
   * @param effectsProfile audio profile to be used for synthesis. (e.g.,
   *     "telephony-class-application")
   * @throws Exception on TextToSpeechClient Errors.
   */
  public static void synthesizeTextWithAudioProfile(String text, String effectsProfile)
      throws Exception {
    // Instantiates a client
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      // Set the text input to be synthesized
      SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

      // Build the voice request
      VoiceSelectionParams voice =
          VoiceSelectionParams.newBuilder()
              .setLanguageCode("en-US") // languageCode = "en_us"
              .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
              .build();

      // Select the type of audio file you want returned and the audio profile
      AudioConfig audioConfig =
          AudioConfig.newBuilder()
              .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
              .addEffectsProfileId(effectsProfile) // audio profile
              .build();

      // Perform the text-to-speech request
      SynthesizeSpeechResponse response =
          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

      // Get the audio contents from the response
      ByteString audioContents = response.getAudioContent();

      // Write the response to the output file.
      try (OutputStream out = new FileOutputStream("output.mp3")) {
        out.write(audioContents.toByteArray());
        System.out.println("Audio content written to file \"output.mp3\"");
      }
    }
  }
  // [END tts_synthesize_text_audio_profile_beta]

  // [START tts_synthesize_ssml]
  /**
   * Demonstrates using the Text to Speech client to synthesize text or ssml.
   *
   * <p>Note: ssml must be well-formed according to: (https://www.w3.org/TR/speech-synthesis/
   * Example: <speak>Hello there.</speak>
   *
   * @param ssml the ssml document to be synthesized. (e.g., "<?xml...")
   * @throws Exception on TextToSpeechClient Errors.
   */
  public static void synthesizeSsml(String ssml) throws Exception {
    // Instantiates a client
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      // Set the ssml input to be synthesized
      SynthesisInput input = SynthesisInput.newBuilder().setSsml(ssml).build();

      // Build the voice request
      VoiceSelectionParams voice =
          VoiceSelectionParams.newBuilder()
              .setLanguageCode("en-US") // languageCode = "en_us"
              .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
              .build();

      // Select the type of audio file you want returned
      AudioConfig audioConfig =
          AudioConfig.newBuilder()
              .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
              .build();

      // Perform the text-to-speech request
      SynthesizeSpeechResponse response =
          textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

      // Get the audio contents from the response
      ByteString audioContents = response.getAudioContent();

      // Write the response to the output file.
      try (OutputStream out = new FileOutputStream("output.mp3")) {
        out.write(audioContents.toByteArray());
        System.out.println("Audio content written to file \"output.mp3\"");
      }
    }
  }
  // [END tts_synthesize_ssml]

  public static void main(String... args) throws Exception {

    ArgumentParser parser =
        ArgumentParsers.newFor("SynthesizeText")
            .build()
            .defaultHelp(true)
            .description("Synthesize a text, text with audio effect profiles, or ssml.");

    MutuallyExclusiveGroup group = parser.addMutuallyExclusiveGroup().required(true);
    group
        .addArgument("--text")
        .help("The text file from which to synthesize speech.")
        .nargs("+")
        .metavar("TEXT", "EFFECTSPROFILE(optional)");
    group.addArgument("--ssml").help("The ssml file from which to synthesize speech.");

    try {
      Namespace namespace = parser.parseArgs(args);

      if ((namespace.get("text") != null)) {
        if (namespace.getList("text").size() == 2) {
          synthesizeTextWithAudioProfile(
              namespace.getList("text").get(0).toString(),
              namespace.getList("text").get(1).toString());

        } else {
          synthesizeText(namespace.getString("text"));
        }

      } else {
        synthesizeSsml(namespace.getString("ssml"));
      }
    } catch (ArgumentParserException e) {
      parser.handleError(e);
    }
  }
}
