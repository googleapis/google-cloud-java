/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.certificatemanager.v1.samples;

// [START certificatemanager_v1_generated_certificatemanagerclient_listcertificatemapentries_certificatemapname_sync]
import com.google.cloud.certificatemanager.v1.CertificateManagerClient;
import com.google.cloud.certificatemanager.v1.CertificateMapEntry;
import com.google.cloud.certificatemanager.v1.CertificateMapName;

public class SyncListCertificateMapEntriesCertificatemapname {

  public static void main(String[] args) throws Exception {
    syncListCertificateMapEntriesCertificatemapname();
  }

  public static void syncListCertificateMapEntriesCertificatemapname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
      CertificateMapName parent =
          CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]");
      for (CertificateMapEntry element :
          certificateManagerClient.listCertificateMapEntries(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END certificatemanager_v1_generated_certificatemanagerclient_listcertificatemapentries_certificatemapname_sync]
