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
package com.google.cloud.dlp.v2;

import com.google.api.core.BetaApi;
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
import com.google.privacy.dlp.v2.DlpServiceGrpc.DlpServiceImplBase;
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
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockDlpServiceImpl extends DlpServiceImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<Object> responses;

  public MockDlpServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessageV3> getRequests() {
    return requests;
  }

  public void addResponse(GeneratedMessageV3 response) {
    responses.add(response);
  }

  public void setResponses(List<GeneratedMessageV3> responses) {
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
      responseObserver.onNext((InspectContentResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void redactImage(
      RedactImageRequest request, StreamObserver<RedactImageResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof RedactImageResponse) {
      requests.add(request);
      responseObserver.onNext((RedactImageResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deidentifyContent(
      DeidentifyContentRequest request,
      StreamObserver<DeidentifyContentResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DeidentifyContentResponse) {
      requests.add(request);
      responseObserver.onNext((DeidentifyContentResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void reidentifyContent(
      ReidentifyContentRequest request,
      StreamObserver<ReidentifyContentResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ReidentifyContentResponse) {
      requests.add(request);
      responseObserver.onNext((ReidentifyContentResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listInfoTypes(
      ListInfoTypesRequest request, StreamObserver<ListInfoTypesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListInfoTypesResponse) {
      requests.add(request);
      responseObserver.onNext((ListInfoTypesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createInspectTemplate(
      CreateInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof InspectTemplate) {
      requests.add(request);
      responseObserver.onNext((InspectTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateInspectTemplate(
      UpdateInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof InspectTemplate) {
      requests.add(request);
      responseObserver.onNext((InspectTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getInspectTemplate(
      GetInspectTemplateRequest request, StreamObserver<InspectTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof InspectTemplate) {
      requests.add(request);
      responseObserver.onNext((InspectTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listInspectTemplates(
      ListInspectTemplatesRequest request,
      StreamObserver<ListInspectTemplatesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListInspectTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext((ListInspectTemplatesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteInspectTemplate(
      DeleteInspectTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createDeidentifyTemplate(
      CreateDeidentifyTemplateRequest request,
      StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DeidentifyTemplate) {
      requests.add(request);
      responseObserver.onNext((DeidentifyTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateDeidentifyTemplate(
      UpdateDeidentifyTemplateRequest request,
      StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DeidentifyTemplate) {
      requests.add(request);
      responseObserver.onNext((DeidentifyTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getDeidentifyTemplate(
      GetDeidentifyTemplateRequest request, StreamObserver<DeidentifyTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DeidentifyTemplate) {
      requests.add(request);
      responseObserver.onNext((DeidentifyTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listDeidentifyTemplates(
      ListDeidentifyTemplatesRequest request,
      StreamObserver<ListDeidentifyTemplatesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDeidentifyTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext((ListDeidentifyTemplatesResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteDeidentifyTemplate(
      DeleteDeidentifyTemplateRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createJobTrigger(
      CreateJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.remove();
    if (response instanceof JobTrigger) {
      requests.add(request);
      responseObserver.onNext((JobTrigger) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateJobTrigger(
      UpdateJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.remove();
    if (response instanceof JobTrigger) {
      requests.add(request);
      responseObserver.onNext((JobTrigger) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getJobTrigger(
      GetJobTriggerRequest request, StreamObserver<JobTrigger> responseObserver) {
    Object response = responses.remove();
    if (response instanceof JobTrigger) {
      requests.add(request);
      responseObserver.onNext((JobTrigger) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listJobTriggers(
      ListJobTriggersRequest request, StreamObserver<ListJobTriggersResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListJobTriggersResponse) {
      requests.add(request);
      responseObserver.onNext((ListJobTriggersResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteJobTrigger(
      DeleteJobTriggerRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createDlpJob(CreateDlpJobRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DlpJob) {
      requests.add(request);
      responseObserver.onNext((DlpJob) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listDlpJobs(
      ListDlpJobsRequest request, StreamObserver<ListDlpJobsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDlpJobsResponse) {
      requests.add(request);
      responseObserver.onNext((ListDlpJobsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getDlpJob(GetDlpJobRequest request, StreamObserver<DlpJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof DlpJob) {
      requests.add(request);
      responseObserver.onNext((DlpJob) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteDlpJob(DeleteDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void cancelDlpJob(CancelDlpJobRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
