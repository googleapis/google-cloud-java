/*
 * Copyright 2021 Google LLC
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

// [START speech_export_to_gcs]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.TranscriptOutputConfig;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.json.JSONObject;

public class ExportToStorageBeta {

  public static void main(String[] args) throws Exception {
    String inputUri = "gs://YOUR_BUCKET_ID/path/to/your/audio_file.wav";
    String outputStorageUri = "gs://YOUR_BUCKET_ID/output_dir_prefix/";
    String objectName = "YOUR_OBJECT_NAME";
    String bucketName = "YOUR_BUCKET_ID";
    String encoding = "LINEAR16"; // encoding of the audio
    int sampleRateHertz = 8000;
    String languageCode = "en-US"; // language code BCP-47_LANGUAGE_CODE_OF_AUDIO
    exportToStorage(
        inputUri,
        outputStorageUri,
        encoding,
        sampleRateHertz,
        languageCode,
        bucketName,
        objectName);
  }

  // Exports the recognized output to specified GCS destination.
  public static void exportToStorage(
      String inputUri,
      String outputStorageUri,
      String encoding,
      int sampleRateHertz,
      String languageCode,
      String bucketName,
      String objectName)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(inputUri).build();

      AudioEncoding audioEncoding = AudioEncoding.valueOf(encoding);

      // Instantiates a client
      Storage storage = StorageOptions.getDefaultInstance().getService();

      // Pass in the URI of the Cloud Storage bucket to hold the transcription
      TranscriptOutputConfig outputConfig =
          TranscriptOutputConfig.newBuilder().setGcsUri(outputStorageUri).build();

      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(audioEncoding)
              .setSampleRateHertz(sampleRateHertz)
              .setLanguageCode(languageCode)
              .build();

      LongRunningRecognizeRequest request =
          LongRunningRecognizeRequest.newBuilder()
              .setConfig(config)
              .setAudio(audio)
              .setOutputConfig(outputConfig)
              .build();

      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
          speechClient.longRunningRecognizeAsync(request);

      System.out.println("Waiting for operation to complete...");
      future.get();

      // Get blob given bucket and object name
      Blob blob = storage.get(BlobId.of(bucketName, objectName));

      // Extract byte contents from blob
      byte[] bytes = blob.getContent();

      // Get decoded representation
      String decoded = new String(bytes, "UTF-8");

      // Create json object
      JSONObject jsonObject = new JSONObject(decoded);

      // Get json string
      String json = jsonObject.toString();

      // Specefy the proto type message
      LongRunningRecognizeResponse.Builder builder = LongRunningRecognizeResponse.newBuilder();

      // Construct a parser
      JsonFormat.Parser parser = JsonFormat.parser().ignoringUnknownFields();

      // Parses from JSON into a protobuf message.
      parser.merge(json, builder);

      // Get the converted values
      LongRunningRecognizeResponse storageResponse = builder.build();

      System.out.println("Results saved to specified output Cloud Storage bucket.");

      String output =
          storageResponse.getResultsList().stream()
              .map(result -> String.valueOf(result.getAlternatives(0).getTranscript()))
              .collect(Collectors.joining("\n"));
      System.out.printf("Transcription: %s", output);
    }
  }
}
// [END speech_export_to_gcs]
