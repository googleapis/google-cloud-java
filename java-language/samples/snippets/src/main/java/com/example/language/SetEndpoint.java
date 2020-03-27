/*
 * Copyright 2019 Google LLC
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

package com.example.language;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.LanguageServiceSettings;
import com.google.cloud.language.v1.Sentiment;
import java.io.IOException;

class SetEndpoint {

  // Change your endpoint
  static void setEndpoint() throws IOException {
    // [START language_set_endpoint]
    LanguageServiceSettings settings =
        LanguageServiceSettings.newBuilder().setEndpoint("eu-language.googleapis.com:443").build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    LanguageServiceClient client = LanguageServiceClient.create(settings);
    // [END language_set_endpoint]

    // The text to analyze
    String text = "Hello, world!";
    Document doc = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

    // Detects the sentiment of the text
    Sentiment sentiment = client.analyzeSentiment(doc).getDocumentSentiment();

    System.out.printf("Text: %s%n", text);
    System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
    client.close();
  }
}
