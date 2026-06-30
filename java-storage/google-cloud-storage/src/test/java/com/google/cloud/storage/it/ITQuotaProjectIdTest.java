/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import java.util.stream.StreamSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.PROD,
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITQuotaProjectIdTest {
  // a project number to a dev project which is not used for CI
  // this value is the negative case, and points to a project which doesn't have access to the
  // bucket used here.
  private static final String BAD_PROJECT_ID = "954355001984";

  @Inject public Storage storage;

  @Inject
  @BucketFixture(BucketType.REQUESTER_PAYS)
  public BucketInfo bucket;

  // make sure there is an object in the bucket to be listed
  @Inject
  @BucketFixture(BucketType.REQUESTER_PAYS)
  public ObjectsFixture objectsFixture;

  private StorageOptions baseOptions;
  private String projectId;
  private GoogleCredentials credentials;

  @Before
  public void setUp() throws Exception {
    baseOptions = storage.getOptions();
    assumeTrue(
        "These tests require GoogleCredentials",
        baseOptions.getCredentials() instanceof GoogleCredentials);
    credentials = (GoogleCredentials) baseOptions.getCredentials();
    projectId = baseOptions.getProjectId();
  }

  /*
   * UserProject precedence
   * 1. Method userProject Option
   * 2. ServiceOptions.getQuotaProjectId()
   * 3. Credentials.quota_project_id
   */

  @Test
  public void fromCredentials() throws Exception {
    StorageOptions build =
        baseOptions.toBuilder()
            .setCredentials(credentialsWithQuotaProjectId(credentials, projectId))
            .build();

    try (Storage s = build.getService()) {
      Page<Blob> page = s.list(bucket.getName());
      assertPage(page);
    }
  }

  @Test
  public void methodOptionOverCredentials() throws Exception {
    StorageOptions build =
        baseOptions.toBuilder()
            .setCredentials(credentialsWithQuotaProjectId(credentials, BAD_PROJECT_ID))
            .build();

    try (Storage s = build.getService()) {
      Page<Blob> page = s.list(bucket.getName(), BlobListOption.userProject(projectId));
      assertPage(page);
    }
  }

  @Test
  public void fromServiceOptionParameter() throws Exception {
    StorageOptions build = baseOptions.toBuilder().setQuotaProjectId(projectId).build();

    try (Storage s = build.getService()) {
      Page<Blob> page = s.list(bucket.getName());
      assertPage(page);
    }
  }

  @Test
  public void serviceOptionParameterOverCredentials() throws Exception {
    StorageOptions build =
        baseOptions.toBuilder()
            .setCredentials(credentialsWithQuotaProjectId(credentials, BAD_PROJECT_ID))
            .setQuotaProjectId(projectId)
            .build();

    try (Storage s = build.getService()) {
      Page<Blob> page = s.list(bucket.getName());
      assertPage(page);
    }
  }

  @Test
  public void methodOptionOverServiceOptionParameter() throws Exception {
    StorageOptions build = baseOptions.toBuilder().setQuotaProjectId(BAD_PROJECT_ID).build();

    try (Storage s = build.getService()) {
      Page<Blob> page = s.list(bucket.getName(), BlobListOption.userProject(projectId));
      assertPage(page);
    }
  }

  private void assertPage(Page<Blob> page) {
    boolean info1InResults =
        StreamSupport.stream(page.iterateAll().spliterator(), false)
            .map(Blob::getName)
            .anyMatch(objectsFixture.getInfo1().getName()::equals);
    assertThat(info1InResults).isTrue();
  }

  private GoogleCredentials credentialsWithQuotaProjectId(
      GoogleCredentials creds, String quotaProjectId) {
    return creds.toBuilder().setQuotaProjectId(quotaProjectId).build();
  }
}
