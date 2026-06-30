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

package com.example.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.cloud.testing.junit4.StdOutCaptureRule;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ITStorageSnippets {

  private static final Logger log = Logger.getLogger(ITStorageSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static Storage storage;
  private static final String PROJECT_ID = Env.GOOGLE_CLOUD_PROJECT;

  @Rule public final StdOutCaptureRule stdOutCaptureRule = new StdOutCaptureRule();

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
  }

  @AfterClass
  public static void afterClass() throws Exception {
    try (Storage ignore = storage) {
      BucketCleaner.doCleanup(BUCKET, storage);
    }
  }

  @Test
  public void testGetServiceAccount() {
    GetServiceAccount.getServiceAccount(PROJECT_ID);
    String snippetOutput = stdOutCaptureRule.getCapturedOutputAsUtf8String();

    assertTrue(snippetOutput.contains("service"));
    assertTrue(snippetOutput.contains("@gs-project-accounts.iam.gserviceaccount.com"));
  }

  @Test
  public void testGenerateSignedPostPolicyV4() throws Exception {
    GenerateSignedPostPolicyV4.generateSignedPostPolicyV4(PROJECT_ID, BUCKET, "my-object");
    String snippetOutput = stdOutCaptureRule.getCapturedOutputAsUtf8String();
    assertTrue(
        snippetOutput.contains("<form action='https://storage.googleapis.com/" + BUCKET + "/'"));
    assertTrue(snippetOutput.contains("<input name='key' value='my-object'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-signature'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-date'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-credential'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-algorithm' value='GOOG4-RSA-SHA256'"));
    assertTrue(snippetOutput.contains("<input name='policy'"));
    assertTrue(snippetOutput.contains("<input name='x-goog-meta-test' value='data'"));
    assertTrue(snippetOutput.contains("<input type='file' name='file'/>"));

    String[] output = snippetOutput.split("'");
    final HttpClient client = HttpClientBuilder.create().build();
    final HttpPost request = new HttpPost(output[1]);
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();

    Map<String, String> policy = new HashMap<>();
    /**
     * When splitting by "'", any element in the form has its value two array elements ahead of it,
     * for example ["x-goog-algorithm", "value=", "GOOG4-RSA-SHA256"] We take advantage of this to
     * make a map which has any policy element easily accessible. The map also has a lot of noise,
     * but we just use the parts we need
     */
    for (int i = 3; i < output.length - 3; i += 2) {
      policy.put(output[i], output[i + 2]);
    }

    builder.addTextBody("x-goog-date", policy.get("x-goog-date"));
    builder.addTextBody("x-goog-meta-test", "data");
    builder.addTextBody("x-goog-algorithm", "GOOG4-RSA-SHA256");
    builder.addTextBody("x-goog-credential", policy.get("x-goog-credential"));
    builder.addTextBody("key", "my-object");
    builder.addTextBody("x-goog-signature", policy.get("x-goog-signature"));
    builder.addTextBody("policy", policy.get("policy"));

    File file = File.createTempFile("temp", "file");
    Files.write(file.toPath(), "hello world".getBytes());
    builder.addBinaryBody(
        "file", new FileInputStream(file), ContentType.APPLICATION_OCTET_STREAM, file.getName());
    request.setEntity(builder.build());

    client.execute(request);

    assertEquals("hello world", new String(storage.get(BUCKET, "my-object").getContent()));
  }
}
