package com.google.cloud.speech.v1;

import com.google.api.gax.longrunning.OperationFuture;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    String gcsUri = "gs://cloud-samples-data/speech/brooklyn_bridge.raw";
    RecognitionConfig recognitionConfig =
        RecognitionConfig.newBuilder()
            .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
            .setSampleRateHertz(16000)
            .setLanguageCode("en-US")
            .build();
    RecognitionAudio recognitionAudio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

    //    System.out.println("Running with gRPC...");
    //    try (SpeechClient speechClient = SpeechClient.create()) {
    //      testSpeechRecognize(speechClient, recognitionConfig, recognitionAudio);
    //    }

    System.out.println("Running with REST...");
    SpeechSettings speechSettings = SpeechSettings.newHttpJsonBuilder().build();
    try (SpeechClient speechClient = SpeechClient.create(speechSettings)) {
      testSpeechRecognize(speechClient, recognitionConfig, recognitionAudio);
    }
  }

  public static void testSpeechRecognize(
      SpeechClient speechClient,
      RecognitionConfig recognitionConfig,
      RecognitionAudio recognitionAudio)
      throws ExecutionException, InterruptedException {
    OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> operationFuture =
        speechClient.longRunningRecognizeAsync(
            LongRunningRecognizeRequest.newBuilder()
                .setConfig(recognitionConfig)
                .setAudio(recognitionAudio)
                .build());
    LongRunningRecognizeResponse longRunningRecognizeResponse = operationFuture.get();
    List<SpeechRecognitionResult> speechRecognitionResultOperationList =
        longRunningRecognizeResponse.getResultsList();
    for (SpeechRecognitionResult speechRecognitionResult : speechRecognitionResultOperationList) {
      System.out.println(
          "Transcript: " + speechRecognitionResult.getAlternatives(0).getTranscript());
    }
  }
}
