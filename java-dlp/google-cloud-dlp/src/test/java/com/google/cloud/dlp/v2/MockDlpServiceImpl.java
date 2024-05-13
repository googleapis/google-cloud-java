/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dlp.v2;

import com.google.api.core.BetaApi;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.ColumnDataProfile;
import com.google.privacy.dlp.v2.Connection;
import com.google.privacy.dlp.v2.CreateConnectionRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteConnectionRequest;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeleteTableDataProfileRequest;
import com.google.privacy.dlp.v2.DiscoveryConfig;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpServiceGrpc.DlpServiceImplBase;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetColumnDataProfileRequest;
import com.google.privacy.dlp.v2.GetConnectionRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetProjectDataProfileRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.GetTableDataProfileRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListColumnDataProfilesRequest;
import com.google.privacy.dlp.v2.ListColumnDataProfilesResponse;
import com.google.privacy.dlp.v2.ListConnectionsRequest;
import com.google.privacy.dlp.v2.ListConnectionsResponse;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListProjectDataProfilesRequest;
import com.google.privacy.dlp.v2.ListProjectDataProfilesResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.ListTableDataProfilesRequest;
import com.google.privacy.dlp.v2.ListTableDataProfilesResponse;
import com.google.privacy.dlp.v2.ProjectDataProfile;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.SearchConnectionsRequest;
import com.google.privacy.dlp.v2.SearchConnectionsResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.TableDataProfile;
import com.google.privacy.dlp.v2.UpdateConnectionRequest;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDlpServiceImpl extends DlpServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDlpServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void inspectContent(
      InspectContentRequest request, StreamObserver<InspectContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InspectContentResponse) {
      requests.add(request);
      responseObserver.onNext(((InspectContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method InspectContent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InspectContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void redactImage(
      RedactImageRequest request, StreamObserver<RedactImageResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RedactImageResponse) {
      requests.add(request);
      responseObserver.onNext(((RedactImageResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RedactImage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RedactImageResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deidentifyContent(
      DeidentifyContentRequest request,
      StreamObserver<DeidentifyContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeidentifyContentResponse) {
      requests.add(request);
      responseObserver.onNext(((DeidentifyContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeidentifyContent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeidentifyContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reidentifyContent(
      ReidentifyContentRequest request,
      StreamObserver<ReidentifyContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReidentifyContentResponse) {
      requests.add(request);
      responseObserver.onNext(((ReidentifyContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReidentifyContent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReidentifyContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInfoTypes(
      ListInfoTypesRequest request, StreamObserver<ListInfoTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInfoTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInfoTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInfoTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInfoTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInspectTemplate(
      CreateInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InspectTemplate) {
      requests.add(request);
      responseObserver.onNext(((InspectTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateInspectTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InspectTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInspectTemplate(
      UpdateInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InspectTemplate) {
      requests.add(request);
      responseObserver.onNext(((InspectTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateInspectTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InspectTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInspectTemplate(
      GetInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InspectTemplate) {
      requests.add(request);
      responseObserver.onNext(((InspectTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInspectTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InspectTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInspectTemplates(
      ListInspectTemplatesRequest request,
      StreamObserver<ListInspectTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInspectTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInspectTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInspectTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInspectTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInspectTemplate(
      DeleteInspectTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteInspectTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeidentifyTemplate(
      CreateDeidentifyTemplateRequest request,
      StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeidentifyTemplate) {
      requests.add(request);
      responseObserver.onNext(((DeidentifyTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeidentifyTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeidentifyTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeidentifyTemplate(
      UpdateDeidentifyTemplateRequest request,
      StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeidentifyTemplate) {
      requests.add(request);
      responseObserver.onNext(((DeidentifyTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeidentifyTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeidentifyTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeidentifyTemplate(
      GetDeidentifyTemplateRequest request, StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeidentifyTemplate) {
      requests.add(request);
      responseObserver.onNext(((DeidentifyTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeidentifyTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeidentifyTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeidentifyTemplates(
      ListDeidentifyTemplatesRequest request,
      StreamObserver<ListDeidentifyTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeidentifyTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeidentifyTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeidentifyTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeidentifyTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeidentifyTemplate(
      DeleteDeidentifyTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDeidentifyTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createJobTrigger(
      CreateJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof JobTrigger) {
      requests.add(request);
      responseObserver.onNext(((JobTrigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateJobTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  JobTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateJobTrigger(
      UpdateJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof JobTrigger) {
      requests.add(request);
      responseObserver.onNext(((JobTrigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateJobTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  JobTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void hybridInspectJobTrigger(
      HybridInspectJobTriggerRequest request,
      StreamObserver<HybridInspectResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HybridInspectResponse) {
      requests.add(request);
      responseObserver.onNext(((HybridInspectResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method HybridInspectJobTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HybridInspectResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getJobTrigger(
      GetJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.poll();
    if (response instanceof JobTrigger) {
      requests.add(request);
      responseObserver.onNext(((JobTrigger) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetJobTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  JobTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listJobTriggers(
      ListJobTriggersRequest request, StreamObserver<ListJobTriggersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListJobTriggersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListJobTriggersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListJobTriggers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListJobTriggersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteJobTrigger(
      DeleteJobTriggerRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteJobTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void activateJobTrigger(
      ActivateJobTriggerRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DlpJob) {
      requests.add(request);
      responseObserver.onNext(((DlpJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ActivateJobTrigger, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DlpJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDiscoveryConfig(
      CreateDiscoveryConfigRequest request, StreamObserver<DiscoveryConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoveryConfig) {
      requests.add(request);
      responseObserver.onNext(((DiscoveryConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDiscoveryConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoveryConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDiscoveryConfig(
      UpdateDiscoveryConfigRequest request, StreamObserver<DiscoveryConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoveryConfig) {
      requests.add(request);
      responseObserver.onNext(((DiscoveryConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDiscoveryConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoveryConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDiscoveryConfig(
      GetDiscoveryConfigRequest request, StreamObserver<DiscoveryConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoveryConfig) {
      requests.add(request);
      responseObserver.onNext(((DiscoveryConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDiscoveryConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoveryConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDiscoveryConfigs(
      ListDiscoveryConfigsRequest request,
      StreamObserver<ListDiscoveryConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDiscoveryConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDiscoveryConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDiscoveryConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDiscoveryConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDiscoveryConfig(
      DeleteDiscoveryConfigRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDiscoveryConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDlpJob(CreateDlpJobRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DlpJob) {
      requests.add(request);
      responseObserver.onNext(((DlpJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDlpJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DlpJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDlpJobs(
      ListDlpJobsRequest request, StreamObserver<ListDlpJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDlpJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDlpJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDlpJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDlpJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDlpJob(GetDlpJobRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DlpJob) {
      requests.add(request);
      responseObserver.onNext(((DlpJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDlpJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DlpJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDlpJob(DeleteDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDlpJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelDlpJob(CancelDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelDlpJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createStoredInfoType(
      CreateStoredInfoTypeRequest request, StreamObserver<StoredInfoType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StoredInfoType) {
      requests.add(request);
      responseObserver.onNext(((StoredInfoType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateStoredInfoType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StoredInfoType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateStoredInfoType(
      UpdateStoredInfoTypeRequest request, StreamObserver<StoredInfoType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StoredInfoType) {
      requests.add(request);
      responseObserver.onNext(((StoredInfoType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateStoredInfoType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StoredInfoType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStoredInfoType(
      GetStoredInfoTypeRequest request, StreamObserver<StoredInfoType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StoredInfoType) {
      requests.add(request);
      responseObserver.onNext(((StoredInfoType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStoredInfoType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StoredInfoType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listStoredInfoTypes(
      ListStoredInfoTypesRequest request,
      StreamObserver<ListStoredInfoTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListStoredInfoTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListStoredInfoTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListStoredInfoTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListStoredInfoTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteStoredInfoType(
      DeleteStoredInfoTypeRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteStoredInfoType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProjectDataProfiles(
      ListProjectDataProfilesRequest request,
      StreamObserver<ListProjectDataProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListProjectDataProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProjectDataProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProjectDataProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListProjectDataProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTableDataProfiles(
      ListTableDataProfilesRequest request,
      StreamObserver<ListTableDataProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTableDataProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTableDataProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTableDataProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTableDataProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listColumnDataProfiles(
      ListColumnDataProfilesRequest request,
      StreamObserver<ListColumnDataProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListColumnDataProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListColumnDataProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListColumnDataProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListColumnDataProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProjectDataProfile(
      GetProjectDataProfileRequest request, StreamObserver<ProjectDataProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProjectDataProfile) {
      requests.add(request);
      responseObserver.onNext(((ProjectDataProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProjectDataProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProjectDataProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTableDataProfile(
      GetTableDataProfileRequest request, StreamObserver<TableDataProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TableDataProfile) {
      requests.add(request);
      responseObserver.onNext(((TableDataProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTableDataProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TableDataProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getColumnDataProfile(
      GetColumnDataProfileRequest request, StreamObserver<ColumnDataProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ColumnDataProfile) {
      requests.add(request);
      responseObserver.onNext(((ColumnDataProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetColumnDataProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ColumnDataProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTableDataProfile(
      DeleteTableDataProfileRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTableDataProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void hybridInspectDlpJob(
      HybridInspectDlpJobRequest request, StreamObserver<HybridInspectResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HybridInspectResponse) {
      requests.add(request);
      responseObserver.onNext(((HybridInspectResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method HybridInspectDlpJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HybridInspectResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void finishDlpJob(FinishDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FinishDlpJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnection(
      CreateConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnection(
      GetConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConnections(
      ListConnectionsRequest request, StreamObserver<ListConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchConnections(
      SearchConnectionsRequest request,
      StreamObserver<SearchConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnection(
      DeleteConnectionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnection(
      UpdateConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }
}
