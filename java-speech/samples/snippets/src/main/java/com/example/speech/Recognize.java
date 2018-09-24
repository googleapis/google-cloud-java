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

package com.example.speech;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1p1beta1.RecognitionMetadata;
import com.google.cloud.speech.v1p1beta1.RecognitionMetadata.InteractionType;
import com.google.cloud.speech.v1p1beta1.RecognitionMetadata.MicrophoneDistance;
import com.google.cloud.speech.v1p1beta1.RecognitionMetadata.RecordingDeviceType;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Recognize {

  /** Run speech recognition tasks. */
  public static void main(String... args) throws Exception {
    if (args.length < 1) {
      System.out.println("Usage:");
      System.out.printf(
          "\tjava %s \"<command>\" \"<path-to-image>\"\n"
              + "Commands:\n"
              + "\t metadata | diarization | multi-channel |\n"
              + "\t multi-language | word-level-conf\n"
              + "Path:\n\tA file path (ex: ./resources/audio.raw) or a URI "
              + "for a Cloud Storage resource (gs://...)\n",
          Recognize.class.getCanonicalName());
      return;
    }
    String command = args[0];
    String path = args.length > 1 ? args[1] : "";

    // Use command and GCS path pattern to invoke transcription.
    if (command.equals("metadata")) {
      transcribeFileWithMetadata(path);
    } else if (command.equals("diarization")) {
      if (path.startsWith("gs://")) {
        transcribeDiarizationGcs(path);
      } else {
        transcribeDiarization(path);
      }
    } else if (command.equals("multi-channel")) {
      if (path.startsWith("gs://")) {
        transcribeMultiChannelGcs(path);
      } else {
        transcribeMultiChannel(path);
      }
    } else if (command.equals("multi-language")) {
      if (path.startsWith("gs://")) {
        transcribeMultiLanguageGcs(path);
      } else {
        transcribeMultiLanguage(path);
      }
    } else if (command.equals("word-level-conf")) {
      if (path.startsWith("gs://")) {
        transcribeWordLevelConfidenceGcs(path);
      } else {
        transcribeWordLevelConfidence(path);
      }
    }
  }

  // [START speech_transcribe_recognition_metadata_beta]
  /**
   * Transcribe the given audio file and include recognition metadata in the request.
   *
   * @param fileName the path to an audio file.
   */
  public static void transcribeFileWithMetadata(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      // Construct a recognition metadata object.
      // Most metadata fields are specified as enums that can be found
      // in speech.enums.RecognitionMetadata
      RecognitionMetadata metadata =
          RecognitionMetadata.newBuilder()
              .setInteractionType(InteractionType.DISCUSSION)
              .setMicrophoneDistance(MicrophoneDistance.NEARFIELD)
              .setRecordingDeviceType(RecordingDeviceType.SMARTPHONE)
              .setRecordingDeviceName("Pixel 2 XL") // Some metadata fields are free form strings
              // And some are integers, for instance the 6 digit NAICS code
              // https://www.naics.com/search/
              .setIndustryNaicsCodeOfAudio(519190)
              .build();

      // Configure request to enable enhanced models
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(8000)
              .setMetadata(metadata) // Add the metadata to the config
              .build();

      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript: %s\n\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_recognition_metadata_beta]

  // [START speech_transcribe_diarization_beta]
  /**
   * Transcribe the given audio file using speaker diarization.
   *
   * @param fileName the path to an audio file.
   */
  public static void transcribeDiarization(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      // Configure request to enable Speaker diarization
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(8000)
              .setEnableSpeakerDiarization(true)
              .setDiarizationSpeakerCount(2)
              .build();

      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just
        // use the first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript : %s\n", alternative.getTranscript());
        // The words array contains the entire transcript up until that point.
        // Referencing the last spoken word to get the associated Speaker tag
        System.out.format(
            "Speaker Tag %s: %s\n",
            alternative.getWords((alternative.getWordsCount() - 1)).getSpeakerTag(),
            alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_diarization_beta]

  // [START speech_transcribe_diarization_gcs_beta]
  /**
   * Transcribe a remote audio file using speaker diarization.
   *
   * @param gcsUri the path to an audio file.
   */
  public static void transcribeDiarizationGcs(String gcsUri) throws Exception {
    try (SpeechClient speechClient = SpeechClient.create()) {
      // Configure request to enable Speaker diarization
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(8000)
              .setEnableSpeakerDiarization(true)
              .setDiarizationSpeakerCount(2)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speechClient.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      for (SpeechRecognitionResult result : response.get().getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just
        // use the first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        // The words array contains the entire transcript up until that point.
        // Referencing the last spoken word to get the associated Speaker tag
        System.out.format(
            "Speaker Tag %s:%s\n",
            alternative.getWords((alternative.getWordsCount() - 1)).getSpeakerTag(),
            alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_diarization_gcs_beta]

  // [START speech_transcribe_multichannel_beta]
  /**
   * Transcribe a local audio file with multi-channel recognition
   *
   * @param fileName the path to local audio file
   */
  public static void transcribeMultiChannel(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      // Get the contents of the local audio file
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();

      // Configure request to enable multiple channels
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(44100)
              .setAudioChannelCount(2)
              .setEnableSeparateRecognitionPerChannel(true)
              .build();

      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript : %s\n", alternative.getTranscript());
        System.out.printf("Channel Tag : %s\n\n", result.getChannelTag());
      }
    }
  }
  // [END speech_transcribe_multichannel_beta]

  // [START speech_transcribe_multichannel_gcs_beta]
  /**
   * Transcribe a remote audio file with multi-channel recognition
   *
   * @param gcsUri the path to the audio file
   */
  public static void transcribeMultiChannelGcs(String gcsUri) throws Exception {

    try (SpeechClient speechClient = SpeechClient.create()) {

      // Configure request to enable multiple channels
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("en-US")
              .setSampleRateHertz(44100)
              .setAudioChannelCount(2)
              .setEnableSeparateRecognitionPerChannel(true)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speechClient.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }
      // Just print the first result here.
      for (SpeechRecognitionResult result : response.get().getResultsList()) {

        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);

        // Print out the result
        System.out.printf("Transcript : %s\n", alternative.getTranscript());
        System.out.printf("Channel Tag : %s\n\n", result.getChannelTag());
      }
    }
  }
  // [END speech_transcribe_multichannel_gcs_beta]

  // [START speech_transcribe_multilanguage_beta]
  /**
   * Transcribe a local audio file with multi-language recognition
   *
   * @param fileName the path to the audio file
   */
  public static void transcribeMultiLanguage(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    // Get the contents of the local audio file
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {

      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();
      ArrayList<String> languageList = new ArrayList<>();
      languageList.add("es-ES");
      languageList.add("en-US");

      // Configure request to enable multiple languages
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setSampleRateHertz(16000)
              .setLanguageCode("ja-JP")
              .addAllAlternativeLanguageCodes(languageList)
              .build();
      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript : %s\n\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_multilanguage_beta]

  // [START speech_transcribe_multilanguage_gcs_beta]
  /**
   * Transcribe a remote audio file with multi-language recognition
   *
   * @param gcsUri the path to the remote audio file
   */
  public static void transcribeMultiLanguageGcs(String gcsUri) throws Exception {
    try (SpeechClient speechClient = SpeechClient.create()) {

      ArrayList<String> languageList = new ArrayList<>();
      languageList.add("es-ES");
      languageList.add("en-US");

      // Configure request to enable multiple languages
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setSampleRateHertz(16000)
              .setLanguageCode("ja-JP")
              .addAllAlternativeLanguageCodes(languageList)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speechClient.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }

      for (SpeechRecognitionResult result : response.get().getResultsList()) {

        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);

        // Print out the result
        System.out.printf("Transcript : %s\n\n", alternative.getTranscript());
      }
    }
  }
  // [END speech_transcribe_multilanguage_gcs_beta]

  // [START speech_transcribe_word_level_confidence_beta]
  /**
   * Transcribe a local audio file with word level confidence
   *
   * @param fileName the path to the local audio file
   */
  public static void transcribeWordLevelConfidence(String fileName) throws Exception {
    Path path = Paths.get(fileName);
    byte[] content = Files.readAllBytes(path);

    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognitionAudio recognitionAudio =
          RecognitionAudio.newBuilder().setContent(ByteString.copyFrom(content)).build();
      // Configure request to enable word level confidence
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setSampleRateHertz(16000)
              .setLanguageCode("en-US")
              .setEnableWordConfidence(true)
              .build();
      // Perform the transcription request
      RecognizeResponse recognizeResponse = speechClient.recognize(config, recognitionAudio);

      // Print out the results
      for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternatives(0);
        System.out.format("Transcript : %s\n", alternative.getTranscript());
        System.out.format(
            "First Word and Confidence : %s %s \n",
            alternative.getWords(0).getWord(), alternative.getWords(0).getConfidence());
      }
    }
  }
  // [END speech_transcribe_word_level_confidence_beta]

  // [START speech_transcribe_word_level_confidence_gcs_beta]
  /**
   * Transcribe a remote audio file with word level confidence
   *
   * @param gcsUri path to the remote audio file
   */
  public static void transcribeWordLevelConfidenceGcs(String gcsUri) throws Exception {
    try (SpeechClient speechClient = SpeechClient.create()) {

      // Configure request to enable word level confidence
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setSampleRateHertz(16000)
              .setLanguageCode("en-US")
              .setEnableWordConfidence(true)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use non-blocking call for getting file transcription
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response =
          speechClient.longRunningRecognizeAsync(config, audio);

      while (!response.isDone()) {
        System.out.println("Waiting for response...");
        Thread.sleep(10000);
      }
      // Just print the first result here.
      SpeechRecognitionResult result = response.get().getResultsList().get(0);

      // There can be several alternative transcripts for a given chunk of speech. Just use the
      // first (most likely) one here.
      SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
      // Print out the result
      System.out.printf("Transcript : %s\n", alternative.getTranscript());
      System.out.format(
          "First Word and Confidence : %s %s \n",
          alternative.getWords(0).getWord(), alternative.getWords(0).getConfidence());
    }
  }
  // [END speech_transcribe_word_level_confidence_gcs_beta]
}
