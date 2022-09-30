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

package com.google.cloud.kms.it;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.GetKeyRingRequest;
import com.google.cloud.kms.v1.KeyManagementServiceGrpc;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.KeyRingName;
import com.google.cloud.kms.v1.LocationName;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.MetadataUtils;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITKmsTest {
  private static final String KMS_KEY_RING_LOCATION = "us";
  private static final String KMS_KEY_RING_NAME = "gcs_test_kms_key_ring";
  private static Metadata requestParamsHeader = new Metadata();
  private static Metadata.Key<String> requestParamsKey =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);
  private static KeyManagementServiceGrpc.KeyManagementServiceBlockingStub kmsStub;

  @Before
  public void setUp() throws IOException {
    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    ManagedChannel kmsChannel =
        ManagedChannelBuilder.forTarget("cloudkms.googleapis.com:443").build();
    kmsStub =
        KeyManagementServiceGrpc.newBlockingStub(kmsChannel)
            .withCallCredentials(MoreCallCredentials.from(credentials));
  }

  @Test
  public void ensureKmsKeyRingExists() {
    String projectId = ServiceOptions.getDefaultProjectId();
    KeyRing keyRing = getKeyRing(kmsStub, projectId);
    Assert.assertNotNull(keyRing);
  }

  private static KeyRing getKeyRing(
      KeyManagementServiceGrpc.KeyManagementServiceBlockingStub kmsStub, String projectId)
      throws StatusRuntimeException {
    String kmsKeyRingResourcePath =
        KeyRingName.of(projectId, ITKmsTest.KMS_KEY_RING_LOCATION, ITKmsTest.KMS_KEY_RING_NAME)
            .toString();
    try {
      GetKeyRingRequest getKeyRingRequest =
          GetKeyRingRequest.newBuilder().setName(kmsKeyRingResourcePath).build();
      requestParamsHeader.put(requestParamsKey, "name=" + kmsKeyRingResourcePath);
      KeyManagementServiceGrpc.KeyManagementServiceBlockingStub stubForGetKeyRing =
          MetadataUtils.attachHeaders(kmsStub, requestParamsHeader);
      return stubForGetKeyRing.getKeyRing(getKeyRingRequest);
    } catch (StatusRuntimeException ex) {
      if (ex.getStatus().getCode() == Status.Code.NOT_FOUND) {
        String keyRingParent =
            LocationName.of(projectId, ITKmsTest.KMS_KEY_RING_LOCATION).toString();
        CreateKeyRingRequest createKeyRingRequest =
            CreateKeyRingRequest.newBuilder()
                .setParent(keyRingParent)
                .setKeyRingId(ITKmsTest.KMS_KEY_RING_NAME)
                .build();
        requestParamsHeader.put(requestParamsKey, "parent=" + keyRingParent);
        KeyManagementServiceGrpc.KeyManagementServiceBlockingStub stubForCreateKeyRing =
            MetadataUtils.attachHeaders(kmsStub, requestParamsHeader);
        return stubForCreateKeyRing.createKeyRing(createKeyRingRequest);
      } else {
        Assert.fail("Error creating or looking up key");
      }
    }
    return null;
  }
}
