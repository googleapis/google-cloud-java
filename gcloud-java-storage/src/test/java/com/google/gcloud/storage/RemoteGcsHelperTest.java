/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;
import com.google.gcloud.storage.testing.RemoteGcsHelper;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class RemoteGcsHelperTest {

  private static final String BUCKET_NAME = "bucket-name";
  private static final String PROJECT_ID = "project-id";
  private static final String JSON_KEY = "{\n"
      + "  \"private_key_id\": \"somekeyid\",\n"
      + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggS"
      + "kAgEAAoIBAQC+K2hSuFpAdrJI\\nnCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHg"
      + "aR\\n0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\nQP/9dJfIkIDJ9Fw9N4"
      + "Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nknddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2"
      + "LgczOjwWHGi99MFjxSer5m9\\n1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa"
      + "\\ndYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n0S31xIe3sSlgW0+UbYlF"
      + "4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\nr6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvL"
      + "sKupSeWAW4tMj3eo/64ge\\nsdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\"
      + "n82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\nCdDw/0jmZTEjpe4S1lxfHp"
      + "lAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FF"
      + "JlbXSRsJMf/Qq39mOR2\\nSpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\nm"
      + "YPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\ngUIi9REwXlGDW0Mz50dxpxcK"
      + "CAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdF"
      + "Cd2UoGddYaOF+KNeM\\nHC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\nECR"
      + "8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\ncoOvtreXCX6XqfrWDtKIvv0vjl"
      + "HBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\nkndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa"
      + "2AY7eafmoU/nZPT\\n00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\nJ7gSi"
      + "dI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\nEfeFCoOX75MxKwXs6xgrw4W//AYG"
      + "GUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\nHtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKk"
      + "XyRDW4IG1Oa2p\\nrALStNBx5Y9t0/LQnFI4w3aG\\n-----END PRIVATE KEY-----\\n\",\n"
      + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
      + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
      + "  \"type\": \"service_account\"\n"
      + "}";
  private static final InputStream JSON_KEY_STREAM = new ByteArrayInputStream(JSON_KEY.getBytes());
  private static final List<BlobInfo> BLOB_LIST = ImmutableList.of(
      BlobInfo.builder(BUCKET_NAME, "n1").build(),
      BlobInfo.builder(BUCKET_NAME, "n2").build());
  private static final StorageException RETRYABLE_EXCEPTION = new StorageException(409, "", true);
  private static final StorageException FATAL_EXCEPTION = new StorageException(500, "", false);
  private static final Page<BlobInfo> BLOB_PAGE = new Page<BlobInfo>() {

    @Override
    public String nextPageCursor() {
      return "nextPageCursor";
    }

    @Override
    public Page<BlobInfo> nextPage() {
      return null;
    }

    @Override
    public Iterable<BlobInfo> values() {
      return BLOB_LIST;
    }

    @Override
    public Iterator<BlobInfo> iterateAll() {
      return BLOB_LIST.iterator();
    }
  };
  private static String keyPath = "/does/not/exist/key." + UUID.randomUUID().toString() + ".json";

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    while (Files.exists(Paths.get(JSON_KEY))) {
      keyPath = "/does/not/exist/key." + UUID.randomUUID().toString() + ".json";
    }
  }

  @Test
  public void testForceDelete() throws InterruptedException, ExecutionException {
    Storage storageMock = EasyMock.createMock(Storage.class);
    EasyMock.expect(storageMock.list(BUCKET_NAME)).andReturn(BLOB_PAGE);
    for (BlobInfo info : BLOB_LIST) {
      EasyMock.expect(storageMock.delete(BUCKET_NAME, info.name())).andReturn(true);
    }
    EasyMock.expect(storageMock.delete(BUCKET_NAME)).andReturn(true);
    EasyMock.replay(storageMock);
    assertTrue(RemoteGcsHelper.forceDelete(storageMock, BUCKET_NAME, 5, TimeUnit.SECONDS));
    EasyMock.verify(storageMock);
  }

  @Test
  public void testForceDeleteTimeout() throws InterruptedException, ExecutionException {
    Storage storageMock = EasyMock.createMock(Storage.class);
    EasyMock.expect(storageMock.list(BUCKET_NAME)).andReturn(BLOB_PAGE).anyTimes();
    for (BlobInfo info : BLOB_LIST) {
      EasyMock.expect(storageMock.delete(BUCKET_NAME, info.name())).andReturn(true).anyTimes();
    }
    EasyMock.expect(storageMock.delete(BUCKET_NAME)).andThrow(RETRYABLE_EXCEPTION).anyTimes();
    EasyMock.replay(storageMock);
    assertTrue(!RemoteGcsHelper.forceDelete(storageMock, BUCKET_NAME, 50, TimeUnit.MICROSECONDS));
    EasyMock.verify(storageMock);
  }

  @Test
  public void testForceDeleteFail() throws InterruptedException, ExecutionException {
    Storage storageMock = EasyMock.createMock(Storage.class);
    EasyMock.expect(storageMock.list(BUCKET_NAME)).andReturn(BLOB_PAGE);
    for (BlobInfo info : BLOB_LIST) {
      EasyMock.expect(storageMock.delete(BUCKET_NAME, info.name())).andReturn(true);
    }
    EasyMock.expect(storageMock.delete(BUCKET_NAME)).andThrow(FATAL_EXCEPTION);
    EasyMock.replay(storageMock);
    thrown.expect(ExecutionException.class);
    try {
      RemoteGcsHelper.forceDelete(storageMock, BUCKET_NAME, 5, TimeUnit.SECONDS);
    } finally {
      EasyMock.verify(storageMock);
    }
  }

  @Test
  public void testCreateFromStream() {
    RemoteGcsHelper helper = RemoteGcsHelper.create(PROJECT_ID, JSON_KEY_STREAM);
    StorageOptions options = helper.options();
    assertEquals(PROJECT_ID, options.projectId());
    assertEquals(60000, options.connectTimeout());
    assertEquals(60000, options.readTimeout());
    assertEquals(10, options.retryParams().retryMaxAttempts());
    assertEquals(6, options.retryParams().retryMinAttempts());
    assertEquals(30000, options.retryParams().maxRetryDelayMillis());
    assertEquals(120000, options.retryParams().totalRetryPeriodMillis());
    assertEquals(250, options.retryParams().initialRetryDelayMillis());
  }

  @Test
  public void testCreateNoKey() {
    thrown.expect(RemoteGcsHelper.GcsHelperException.class);
    thrown.expectMessage(keyPath + " (No such file or directory)");
    RemoteGcsHelper.create(PROJECT_ID, keyPath);
  }
}
