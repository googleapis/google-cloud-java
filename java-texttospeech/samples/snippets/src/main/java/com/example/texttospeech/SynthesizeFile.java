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
import com.google.cloud.texttospeech.v1.AudioConfig;
import com.google.cloud.texttospeech.v1.AudioEncoding;
import com.google.cloud.texttospeech.v1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1.SynthesisInput;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.VoiceSelectionParams;
import com.google.protobuf.ByteString;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.MutuallyExclusiveGroup;
import net.sourceforge.argparse4j.inf.Namespace;


/**
 * Google Cloud TextToSpeech API sample application.
 * Example usage: mvn package exec:java -Dexec.mainClass='com.example.texttospeech.SynthesizeFile'
 *                                      -Dexec.args='--text resources/hello.txt'
 */
public class SynthesizeFile {

  // [START tts_synthesize_text_file]
  /**
   * Demonstrates using the Text to Speech client to synthesize a text file or ssml file.
   * @param textFile the text file to be synthesized. (e.g., hello.txt)
   * @throws Exception on TextToSpeechClient Errors.
   */
  public static ByteString synthesizeTextFile(String textFile)
      throws Exception {
    // Instantiates a client
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      // Read the file's contents
      String contents = new String(Files.readAllBytes(Paths.get(textFile)));
      // Set the text input to be synthesized
      SynthesisInput input = SynthesisInput.newBuilder()
          .setText(contents)
          .build();

      // Build the voice request
      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
          .setLanguageCode("en-US") // languageCode = "en_us"
          .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
          .build();

      // Select the type of audio file you want returned
      AudioConfig audioConfig = AudioConfig.newBuilder()
          .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
          .build();

      // Perform the text-to-speech request
      SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice,
          audioConfig);

      // Get the audio contents from the response
      ByteString audioContents = response.getAudioContent();

      // Write the response to the output file.
      try (OutputStream out = new FileOutputStream("output.mp3")) {
        out.write(audioContents.toByteArray());
        System.out.println("Audio content written to file \"output.mp3\"");
        return audioContents;
      }
    }
  }
  // [END tts_synthesize_text_file]


  // [START tts_synthesize_ssml_file]
  /**
   * Demonstrates using the Text to Speech client to synthesize a text file or ssml file.
   * @param ssmlFile the ssml document to be synthesized. (e.g., hello.ssml)
   * @throws Exception on TextToSpeechClient Errors.
   */
  public static ByteString synthesizeSsmlFile(String ssmlFile)
      throws Exception {
    // Instantiates a client
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      // Read the file's contents
      String contents = new String(Files.readAllBytes(Paths.get(ssmlFile)));
      // Set the ssml input to be synthesized
      SynthesisInput input = SynthesisInput.newBuilder()
          .setSsml(contents)
          .build();

      // Build the voice request
      VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
          .setLanguageCode("en-US") // languageCode = "en_us"
          .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
          .build();

      // Select the type of audio file you want returned
      AudioConfig audioConfig = AudioConfig.newBuilder()
          .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
          .build();

      // Perform the text-to-speech request
      SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice,
          audioConfig);

      // Get the audio contents from the response
      ByteString audioContents = response.getAudioContent();

      // Write the response to the output file.
      try (OutputStream out = new FileOutputStream("output.mp3")) {
        out.write(audioContents.toByteArray());
        System.out.println("Audio content written to file \"output.mp3\"");
        return audioContents;
      }
    }
  }
  // [END tts_synthesize_ssml_file]
}