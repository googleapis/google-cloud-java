/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dlp.v2.stub;

import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for DLP API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class DlpServiceStub implements BackgroundResource {

  public UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable() {
    throw new UnsupportedOperationException("Not implemented: inspectContentCallable()");
  }

  public UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable() {
    throw new UnsupportedOperationException("Not implemented: redactImageCallable()");
  }

  public UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    throw new UnsupportedOperationException("Not implemented: deidentifyContentCallable()");
  }

  public UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable() {
    throw new UnsupportedOperationException("Not implemented: reidentifyContentCallable()");
  }

  public UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInfoTypesCallable()");
  }

  public UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createInspectTemplateCallable()");
  }

  public UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInspectTemplateCallable()");
  }

  public UnaryCallable<GetInspectTemplateRequest, InspectTemplate> getInspectTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getInspectTemplateCallable()");
  }

  public UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInspectTemplatesPagedCallable()");
  }

  public UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInspectTemplatesCallable()");
  }

  public UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInspectTemplateCallable()");
  }

  public UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeidentifyTemplateCallable()");
  }

  public UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeidentifyTemplateCallable()");
  }

  public UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeidentifyTemplateCallable()");
  }

  public UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDeidentifyTemplatesPagedCallable()");
  }

  public UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeidentifyTemplatesCallable()");
  }

  public UnaryCallable<DeleteDeidentifyTemplateRequest, Empty> deleteDeidentifyTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDeidentifyTemplateCallable()");
  }

  public UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createDlpJobCallable()");
  }

  public UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse> listDlpJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDlpJobsPagedCallable()");
  }

  public UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDlpJobsCallable()");
  }

  public UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getDlpJobCallable()");
  }

  public UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDlpJobCallable()");
  }

  public UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelDlpJobCallable()");
  }

  public UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobTriggersPagedCallable()");
  }

  public UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse> listJobTriggersCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobTriggersCallable()");
  }

  public UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: getJobTriggerCallable()");
  }

  public UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteJobTriggerCallable()");
  }

  public UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: updateJobTriggerCallable()");
  }

  public UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable() {
    throw new UnsupportedOperationException("Not implemented: createJobTriggerCallable()");
  }
}
