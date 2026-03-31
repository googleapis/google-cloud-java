/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.storage.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RemoteStorageHelperTest {

  private static final String BUCKET_NAME = "bucket-name";
  private static final String PROJECT_ID = "project-id";
  private static final String JSON_KEY =
      "{\n"
          + "  \"private_key_id\": \"somekeyid\",\n"
          + "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\n"
          + "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC+K2hSuFpAdrJI\\n"
          + "nCgcDz2M7t7bjdlsadsasad+fvRSW6TjNQZ3p5LLQY1kSZRqBqylRkzteMOyHgaR\\n"
          + "0Pmxh3ILCND5men43j3h4eDbrhQBuxfEMalkG92sL+PNQSETY2tnvXryOvmBRwa/\\n"
          + "QP/9dJfIkIDJ9Fw9N4Bhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\n"
          + "knddadwkwewcVxHFhcZJO+XWf6ofLUXpRwiTZakGMn8EE1uVa2LgczOjwWHGi99MFjxSer5m9\\n"
          + "1tCa3/KEGKiS/YL71JvjwX3mb+cewlkcmweBKZHM2JPTk0ZednFSpVZMtycjkbLa\\n"
          + "dYOS8V85AgMBewECggEBAKksaldajfDZDV6nGqbFjMiizAKJolr/M3OQw16K6o3/\\n"
          + "0S31xIe3sSlgW0+UbYlF4U8KifhManD1apVSC3csafaspP4RZUHFhtBywLO9pR5c\\n"
          + "r6S5aLp+gPWFyIp1pfXbWGvc5VY/v9x7ya1VEa6rXvLsKupSeWAW4tMj3eo/64ge\\n"
          + "sdaceaLYw52KeBYiT6+vpsnYrEkAHO1fF/LavbLLOFJmFTMxmsNaG0tuiJHgjshB\\n"
          + "82DpMCbXG9YcCgI/DbzuIjsdj2JC1cascSP//3PmefWysucBQe7Jryb6NQtASmnv\\n"
          + "CdDw/0jmZTEjpe4S1lxfHplAhHFtdgYTvyYtaLZiVVkCgYEA8eVpof2rceecw/I6\\n"
          + "5ng1q3Hl2usdWV/4mZMvR0fOemacLLfocX6IYxT1zA1FFJlbXSRsJMf/Qq39mOR2\\n"
          + "SpW+hr4jCoHeRVYLgsbggtrevGmILAlNoqCMpGZ6vDmJpq6ECV9olliDvpPgWOP+\\n"
          + "mYPDreFBGxWvQrADNbRt2dmGsrsCgYEAyUHqB2wvJHFqdmeBsaacewzV8x9WgmeX\\n"
          + "gUIi9REwXlGDW0Mz50dxpxcKCAYn65+7TCnY5O/jmL0VRxU1J2mSWyWTo1C+17L0\\n"
          + "3fUqjxL1pkefwecxwecvC+gFFYdJ4CQ/MHHXU81Lwl1iWdFCd2UoGddYaOF+KNeM\\n"
          + "HC7cmqra+JsCgYEAlUNywzq8nUg7282E+uICfCB0LfwejuymR93CtsFgb7cRd6ak\\n"
          + "ECR8FGfCpH8ruWJINllbQfcHVCX47ndLZwqv3oVFKh6pAS/vVI4dpOepP8++7y1u\\n"
          + "coOvtreXCX6XqfrWDtKIvv0vjlHBhhhp6mCcRpdQjV38H7JsyJ7lih/oNjECgYAt\\n"
          + "kndj5uNl5SiuVxHFhcZJO+XWf6ofLUregtevZakGMn8EE1uVa2AY7eafmoU/nZPT\\n"
          + "00YB0TBATdCbn/nBSuKDESkhSg9s2GEKQZG5hBmL5uCMfo09z3SfxZIhJdlerreP\\n"
          + "J7gSidI12N+EZxYd4xIJh/HFDgp7RRO87f+WJkofMQKBgGTnClK1VMaCRbJZPriw\\n"
          + "EfeFCoOX75MxKwXs6xgrw4W//AYGGUjDt83lD6AZP6tws7gJ2IwY/qP7+lyhjEqN\\n"
          + "HtfPZRGFkGZsdaksdlaksd323423d+15/UvrlRSFPNj1tWQmNKkXyRDW4IG1Oa2p\\n"
          + "rALStNBx5Y9t0/LQnFI4w3aG\\n"
          + "-----END PRIVATE KEY-----\\n"
          + "\",\n"
          + "  \"client_email\": \"someclientid@developer.gserviceaccount.com\",\n"
          + "  \"client_id\": \"someclientid.apps.googleusercontent.com\",\n"
          + "  \"type\": \"service_account\"\n"
          + "}";
  private static final InputStream JSON_KEY_STREAM = new ByteArrayInputStream(JSON_KEY.getBytes());
  private static final StorageException RETRYABLE_EXCEPTION = new StorageException(409, "");
  private static final StorageException FATAL_EXCEPTION = new StorageException(500, "");
  private static final String BLOB_NAME2 = "n2";
  private static final BlobId BLOB_ID1 = BlobId.of(BUCKET_NAME, "n1");
  private static final BlobId BLOB_ID2 = BlobId.of(BUCKET_NAME, BLOB_NAME2);

  private Blob blob1;
  private Blob blob2;
  private List<Blob> blobList;
  private Page<Blob> blobPage;

  @Before
  public void setUp() {
    blob1 = Mockito.mock(Blob.class);
    blob2 = Mockito.mock(Blob.class);
    blobList = ImmutableList.of(blob1, blob2);
    blobPage =
        new Page<Blob>() {

          @Override
          public boolean hasNextPage() {
            return true;
          }

          @Override
          public String getNextPageToken() {
            return "nextPageCursor";
          }

          @Override
          public Page<Blob> getNextPage() {
            return null;
          }

          @Override
          public Iterable<Blob> getValues() {
            return blobList;
          }

          @Override
          public Iterable<Blob> iterateAll() {
            return blobList;
          }
        };
  }

  @Test
  public void testForceDelete() throws InterruptedException, ExecutionException {
    Storage storageMock = Mockito.mock(Storage.class);
    when(blob1.getBlobId()).thenReturn(BLOB_ID1);
    when(blob2.getBlobId()).thenReturn(BLOB_ID2);

    ArrayList<BlobId> ids = new ArrayList<>();
    ids.add(BLOB_ID1);
    ids.add(BLOB_ID2);
    when(storageMock.delete(ids)).thenReturn(Collections.nCopies(2, true));
    when(storageMock.list(BUCKET_NAME, BlobListOption.versions(true))).thenReturn(blobPage);
    when(storageMock.delete(BUCKET_NAME)).thenReturn(true);
    assertTrue(RemoteStorageHelper.forceDelete(storageMock, BUCKET_NAME, 5, TimeUnit.SECONDS));

    verify(blob1).getBlobId();
    verify(blob2).getBlobId();
    verify(storageMock).delete(ids);
    verify(storageMock).list(BUCKET_NAME, BlobListOption.versions(true));
    verify(storageMock).delete(BUCKET_NAME);
  }

  @Test
  public void testForceDeleteTimeout() throws InterruptedException, ExecutionException {
    Storage storageMock = Mockito.mock(Storage.class);

    when(blob1.getBlobId()).thenReturn(BLOB_ID1);
    when(blob2.getBlobId()).thenReturn(BLOB_ID2);

    ArrayList<BlobId> ids = new ArrayList<>();
    ids.add(BLOB_ID1);
    ids.add(BLOB_ID2);
    when(storageMock.delete(ids)).thenReturn(Collections.nCopies(2, true));

    when(storageMock.list(BUCKET_NAME, BlobListOption.versions(true))).thenReturn(blobPage);
    when(storageMock.delete(BUCKET_NAME)).thenThrow(RETRYABLE_EXCEPTION);
    assertFalse(
        RemoteStorageHelper.forceDelete(storageMock, BUCKET_NAME, 50, TimeUnit.MICROSECONDS));
  }

  @Test
  public void testForceDeleteFail() throws InterruptedException, ExecutionException {
    Storage storageMock = Mockito.mock(Storage.class);
    when(blob1.getBlobId()).thenReturn(BLOB_ID1);
    when(blob2.getBlobId()).thenReturn(BLOB_ID2);
    ArrayList<BlobId> ids = new ArrayList<>();
    ids.add(BLOB_ID1);
    ids.add(BLOB_ID2);
    when(storageMock.delete(ids)).thenReturn(Collections.nCopies(2, true));
    when(storageMock.list(BUCKET_NAME, BlobListOption.versions(true))).thenReturn(blobPage);
    when(storageMock.delete(BUCKET_NAME)).thenThrow(FATAL_EXCEPTION);
    try {
      RemoteStorageHelper.forceDelete(storageMock, BUCKET_NAME, 5, TimeUnit.SECONDS);
      Assert.fail();
    } catch (ExecutionException ex) {
      assertNotNull(ex.getMessage());
    } finally {
      verify(blob1).getBlobId();
      verify(blob2).getBlobId();
      verify(storageMock).delete(ids);
      verify(storageMock).list(BUCKET_NAME, BlobListOption.versions(true));
      verify(storageMock).delete(BUCKET_NAME);
    }
  }

  @Test
  public void testForceDeleteNoTimeout() {
    Storage storageMock = Mockito.mock(Storage.class);
    when(blob1.getBlobId()).thenReturn(BLOB_ID1);
    when(blob2.getBlobId()).thenReturn(BLOB_ID2);
    ArrayList<BlobId> ids = new ArrayList<>();
    ids.add(BLOB_ID1);
    ids.add(BLOB_ID2);
    when(storageMock.delete(ids)).thenReturn(Collections.nCopies(2, true));
    when(storageMock.list(BUCKET_NAME, BlobListOption.versions(true))).thenReturn(blobPage);
    when(storageMock.delete(BUCKET_NAME)).thenReturn(true);
    RemoteStorageHelper.forceDelete(storageMock, BUCKET_NAME);

    verify(blob1).getBlobId();
    verify(blob2).getBlobId();
    verify(storageMock).delete(ids);
    verify(storageMock).list(BUCKET_NAME, BlobListOption.versions(true));
    verify(storageMock).delete(BUCKET_NAME);
  }

  @Test
  public void testForceDeleteNoTimeoutFail() {
    Storage storageMock = Mockito.mock(Storage.class);
    when(blob1.getBlobId()).thenReturn(BLOB_ID1);
    when(blob2.getBlobId()).thenReturn(BLOB_ID2);
    ArrayList<BlobId> ids = new ArrayList<>();
    ids.add(BLOB_ID1);
    ids.add(BLOB_ID2);
    when(storageMock.delete(ids)).thenReturn(Collections.nCopies(2, true));
    when(storageMock.list(BUCKET_NAME, BlobListOption.versions(true))).thenReturn(blobPage);
    when(storageMock.delete(BUCKET_NAME)).thenThrow(FATAL_EXCEPTION);
    try {
      RemoteStorageHelper.forceDelete(storageMock, BUCKET_NAME);
      Assert.fail();
    } catch (StorageException ex) {
      assertNotNull(ex.getMessage());
    } finally {
      verify(blob1).getBlobId();
      verify(blob2).getBlobId();
      verify(storageMock).delete(ids);
      verify(storageMock).list(BUCKET_NAME, BlobListOption.versions(true));
      verify(storageMock).delete(BUCKET_NAME);
    }
  }

  @Test
  public void testForceDeleteRetriesWithUserProject() throws Exception {
    final String USER_PROJECT = "user-project";
    Storage storageMock = Mockito.mock(Storage.class);
    when(blob1.getBlobId()).thenReturn(BLOB_ID1);
    when(blob2.getBlobId()).thenReturn(BLOB_ID2);
    ArrayList<BlobId> ids = new ArrayList<>();
    ids.add(BLOB_ID1);
    ids.add(BLOB_ID2);
    when(storageMock.delete(ids)).thenReturn(ImmutableList.of(Boolean.TRUE, Boolean.FALSE));
    when(storageMock.delete(
            BUCKET_NAME, BLOB_NAME2, Storage.BlobSourceOption.userProject(USER_PROJECT)))
        .thenReturn(true);
    when(storageMock.list(
            BUCKET_NAME, BlobListOption.versions(true), BlobListOption.userProject(USER_PROJECT)))
        .thenReturn(blobPage);
    when(storageMock.delete(BUCKET_NAME, Storage.BucketSourceOption.userProject(USER_PROJECT)))
        .thenReturn(true);
    try {
      RemoteStorageHelper.forceDelete(storageMock, BUCKET_NAME, 5, TimeUnit.SECONDS, USER_PROJECT);
    } finally {
      verify(blob1).getBlobId();
      verify(blob2).getBlobId();
      verify(storageMock).delete(ids);
      verify(storageMock)
          .delete(BUCKET_NAME, BLOB_NAME2, Storage.BlobSourceOption.userProject(USER_PROJECT));
      verify(storageMock)
          .list(
              BUCKET_NAME, BlobListOption.versions(true), BlobListOption.userProject(USER_PROJECT));
      verify(storageMock).delete(BUCKET_NAME, Storage.BucketSourceOption.userProject(USER_PROJECT));
    }
  }

  @Test
  public void testCreateFromStream() {
    RemoteStorageHelper helper = RemoteStorageHelper.create(PROJECT_ID, JSON_KEY_STREAM);
    StorageOptions options = helper.getOptions();
    assertEquals(PROJECT_ID, options.getProjectId());
    assertEquals(60000, ((HttpTransportOptions) options.getTransportOptions()).getConnectTimeout());
    assertEquals(60000, ((HttpTransportOptions) options.getTransportOptions()).getReadTimeout());
    assertEquals(10, options.getRetrySettings().getMaxAttempts());
    assertEquals(Duration.ofMillis(30000), options.getRetrySettings().getMaxRetryDelayDuration());
    assertEquals(Duration.ofMillis(120000), options.getRetrySettings().getTotalTimeoutDuration());
    assertEquals(Duration.ofMillis(250), options.getRetrySettings().getInitialRetryDelayDuration());
  }
}
