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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_read_and_write_files")
// sample-metadata:
//   title: Read binary file into bytes field & write string in response to file
//   description: Read binary file into bytes field & write string in response to file
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SamplegenReadAndWriteFiles

package com.google.cloud.examples.speech.v1p1beta1;

import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.protobuf.ByteString;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SamplegenReadAndWriteFiles {
  // [START samplegen_read_and_write_files]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
   * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
   * import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
   * import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
   * import com.google.cloud.speech.v1p1beta1.SpeechClient;
   * import com.google.protobuf.ByteString;
   * import java.io.FileWriter;
   * import java.nio.file.Files;
   * import java.nio.file.Path;
   * import java.nio.file.Paths;
   */

  /** Read binary file into bytes field &amp; write string in response to file */
  public static void sampleRecognize() {
    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.MP3;
      RecognitionConfig config = RecognitionConfig.newBuilder().setEncoding(encoding).build();

      // The bytes from this file will be read into `content`
      Path path = Paths.get("path/to/file.mp3");
      byte[] data = Files.readAllBytes(path);
      ByteString content = ByteString.copyFrom(data);
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      RecognizeResponse response = speechClient.recognize(request);
      // Your audio has been transcribed.
      // Writing audio transcript to transcript.txt for demonstration:
      try (FileWriter writer = new FileWriter("transcript.txt")) {
        writer.write(response.getResultsList().get(0).getAlternativesList().get(0).getTranscript());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_read_and_write_files]

  public static void main(String[] args) {
    sampleRecognize();
  }
}
