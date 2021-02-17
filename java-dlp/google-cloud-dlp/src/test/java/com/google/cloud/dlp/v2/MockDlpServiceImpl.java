/*
 * Copyright 2020 Google LLC
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
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.DlpServiceGrpc.DlpServiceImplBase;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
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
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
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
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  InspectContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void redactImage(
      RedactImageRequest request, StreamObserver<RedactImageResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  RedactImageResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deidentifyContent(
      DeidentifyContentRequest request,
      StreamObserver<DeidentifyContentResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DeidentifyContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reidentifyContent(
      ReidentifyContentRequest request,
      StreamObserver<ReidentifyContentResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ReidentifyContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInfoTypes(
      ListInfoTypesRequest request, StreamObserver<ListInfoTypesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListInfoTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInspectTemplate(
      CreateInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  InspectTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInspectTemplate(
      UpdateInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  InspectTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInspectTemplate(
      GetInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  InspectTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInspectTemplates(
      ListInspectTemplatesRequest request,
      StreamObserver<ListInspectTemplatesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListInspectTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInspectTemplate(
      DeleteInspectTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeidentifyTemplate(
      CreateDeidentifyTemplateRequest request,
      StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DeidentifyTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeidentifyTemplate(
      UpdateDeidentifyTemplateRequest request,
      StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DeidentifyTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeidentifyTemplate(
      GetDeidentifyTemplateRequest request, StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DeidentifyTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeidentifyTemplates(
      ListDeidentifyTemplatesRequest request,
      StreamObserver<ListDeidentifyTemplatesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListDeidentifyTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeidentifyTemplate(
      DeleteDeidentifyTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createJobTrigger(
      CreateJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  JobTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateJobTrigger(
      UpdateJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  JobTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void hybridInspectJobTrigger(
      HybridInspectJobTriggerRequest request,
      StreamObserver<HybridInspectResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  HybridInspectResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getJobTrigger(
      GetJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  JobTrigger.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listJobTriggers(
      ListJobTriggersRequest request, StreamObserver<ListJobTriggersResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListJobTriggersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteJobTrigger(
      DeleteJobTriggerRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void activateJobTrigger(
      ActivateJobTriggerRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DlpJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDlpJob(CreateDlpJobRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DlpJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDlpJobs(
      ListDlpJobsRequest request, StreamObserver<ListDlpJobsResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListDlpJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDlpJob(GetDlpJobRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  DlpJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDlpJob(DeleteDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelDlpJob(CancelDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createStoredInfoType(
      CreateStoredInfoTypeRequest request, StreamObserver<StoredInfoType> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  StoredInfoType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateStoredInfoType(
      UpdateStoredInfoTypeRequest request, StreamObserver<StoredInfoType> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  StoredInfoType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStoredInfoType(
      GetStoredInfoTypeRequest request, StreamObserver<StoredInfoType> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  StoredInfoType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listStoredInfoTypes(
      ListStoredInfoTypesRequest request,
      StreamObserver<ListStoredInfoTypesResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  ListStoredInfoTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteStoredInfoType(
      DeleteStoredInfoTypeRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void hybridInspectDlpJob(
      HybridInspectDlpJobRequest request, StreamObserver<HybridInspectResponse> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  HybridInspectResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void finishDlpJob(FinishDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
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
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
