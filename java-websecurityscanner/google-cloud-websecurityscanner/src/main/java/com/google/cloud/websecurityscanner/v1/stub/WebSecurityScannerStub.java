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

package com.google.cloud.websecurityscanner.v1.stub;

import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListCrawledUrlsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListFindingsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListScanConfigsPagedResponse;
import static com.google.cloud.websecurityscanner.v1.WebSecurityScannerClient.ListScanRunsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.websecurityscanner.v1.CreateScanConfigRequest;
import com.google.cloud.websecurityscanner.v1.DeleteScanConfigRequest;
import com.google.cloud.websecurityscanner.v1.Finding;
import com.google.cloud.websecurityscanner.v1.GetFindingRequest;
import com.google.cloud.websecurityscanner.v1.GetScanConfigRequest;
import com.google.cloud.websecurityscanner.v1.GetScanRunRequest;
import com.google.cloud.websecurityscanner.v1.ListCrawledUrlsRequest;
import com.google.cloud.websecurityscanner.v1.ListCrawledUrlsResponse;
import com.google.cloud.websecurityscanner.v1.ListFindingTypeStatsRequest;
import com.google.cloud.websecurityscanner.v1.ListFindingTypeStatsResponse;
import com.google.cloud.websecurityscanner.v1.ListFindingsRequest;
import com.google.cloud.websecurityscanner.v1.ListFindingsResponse;
import com.google.cloud.websecurityscanner.v1.ListScanConfigsRequest;
import com.google.cloud.websecurityscanner.v1.ListScanConfigsResponse;
import com.google.cloud.websecurityscanner.v1.ListScanRunsRequest;
import com.google.cloud.websecurityscanner.v1.ListScanRunsResponse;
import com.google.cloud.websecurityscanner.v1.ScanConfig;
import com.google.cloud.websecurityscanner.v1.ScanRun;
import com.google.cloud.websecurityscanner.v1.StartScanRunRequest;
import com.google.cloud.websecurityscanner.v1.StopScanRunRequest;
import com.google.cloud.websecurityscanner.v1.UpdateScanConfigRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WebSecurityScanner service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WebSecurityScannerStub implements BackgroundResource {

  public UnaryCallable<CreateScanConfigRequest, ScanConfig> createScanConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createScanConfigCallable()");
  }

  public UnaryCallable<DeleteScanConfigRequest, Empty> deleteScanConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScanConfigCallable()");
  }

  public UnaryCallable<GetScanConfigRequest, ScanConfig> getScanConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getScanConfigCallable()");
  }

  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsPagedResponse>
      listScanConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listScanConfigsPagedCallable()");
  }

  public UnaryCallable<ListScanConfigsRequest, ListScanConfigsResponse> listScanConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listScanConfigsCallable()");
  }

  public UnaryCallable<UpdateScanConfigRequest, ScanConfig> updateScanConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScanConfigCallable()");
  }

  public UnaryCallable<StartScanRunRequest, ScanRun> startScanRunCallable() {
    throw new UnsupportedOperationException("Not implemented: startScanRunCallable()");
  }

  public UnaryCallable<GetScanRunRequest, ScanRun> getScanRunCallable() {
    throw new UnsupportedOperationException("Not implemented: getScanRunCallable()");
  }

  public UnaryCallable<ListScanRunsRequest, ListScanRunsPagedResponse> listScanRunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listScanRunsPagedCallable()");
  }

  public UnaryCallable<ListScanRunsRequest, ListScanRunsResponse> listScanRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listScanRunsCallable()");
  }

  public UnaryCallable<StopScanRunRequest, ScanRun> stopScanRunCallable() {
    throw new UnsupportedOperationException("Not implemented: stopScanRunCallable()");
  }

  public UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsPagedResponse>
      listCrawledUrlsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCrawledUrlsPagedCallable()");
  }

  public UnaryCallable<ListCrawledUrlsRequest, ListCrawledUrlsResponse> listCrawledUrlsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCrawledUrlsCallable()");
  }

  public UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getFindingCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsPagedCallable()");
  }

  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingsCallable()");
  }

  public UnaryCallable<ListFindingTypeStatsRequest, ListFindingTypeStatsResponse>
      listFindingTypeStatsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFindingTypeStatsCallable()");
  }

  @Override
  public abstract void close();
}
