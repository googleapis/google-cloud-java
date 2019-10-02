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
package com.google.cloud.datacatalog.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.datacatalog.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.CreateEntryRequest;
import com.google.cloud.datacatalog.CreateTagRequest;
import com.google.cloud.datacatalog.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.DataCatalogGrpc.DataCatalogImplBase;
import com.google.cloud.datacatalog.DeleteEntryGroupRequest;
import com.google.cloud.datacatalog.DeleteEntryRequest;
import com.google.cloud.datacatalog.DeleteTagRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.Entry;
import com.google.cloud.datacatalog.EntryGroup;
import com.google.cloud.datacatalog.GetEntryGroupRequest;
import com.google.cloud.datacatalog.GetEntryRequest;
import com.google.cloud.datacatalog.GetTagTemplateRequest;
import com.google.cloud.datacatalog.ListTagsRequest;
import com.google.cloud.datacatalog.ListTagsResponse;
import com.google.cloud.datacatalog.LookupEntryRequest;
import com.google.cloud.datacatalog.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.SearchCatalogRequest;
import com.google.cloud.datacatalog.SearchCatalogResponse;
import com.google.cloud.datacatalog.Tag;
import com.google.cloud.datacatalog.TagTemplate;
import com.google.cloud.datacatalog.TagTemplateField;
import com.google.cloud.datacatalog.UpdateEntryRequest;
import com.google.cloud.datacatalog.UpdateTagRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockDataCatalogImpl extends DataCatalogImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataCatalogImpl() {
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
  public void searchCatalog(
      SearchCatalogRequest request, StreamObserver<SearchCatalogResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchCatalogResponse) {
      requests.add(request);
      responseObserver.onNext((SearchCatalogResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createEntryGroup(
      CreateEntryGroupRequest request, StreamObserver<EntryGroup> responseObserver) {
    Object response = responses.remove();
    if (response instanceof EntryGroup) {
      requests.add(request);
      responseObserver.onNext((EntryGroup) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getEntryGroup(
      GetEntryGroupRequest request, StreamObserver<EntryGroup> responseObserver) {
    Object response = responses.remove();
    if (response instanceof EntryGroup) {
      requests.add(request);
      responseObserver.onNext((EntryGroup) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteEntryGroup(
      DeleteEntryGroupRequest request, StreamObserver<Empty> responseObserver) {
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
  public void createEntry(CreateEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext((Entry) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateEntry(UpdateEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext((Entry) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteEntry(DeleteEntryRequest request, StreamObserver<Empty> responseObserver) {
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
  public void getEntry(GetEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext((Entry) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void lookupEntry(LookupEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext((Entry) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createTagTemplate(
      CreateTagTemplateRequest request, StreamObserver<TagTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TagTemplate) {
      requests.add(request);
      responseObserver.onNext((TagTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getTagTemplate(
      GetTagTemplateRequest request, StreamObserver<TagTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TagTemplate) {
      requests.add(request);
      responseObserver.onNext((TagTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateTagTemplate(
      UpdateTagTemplateRequest request, StreamObserver<TagTemplate> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TagTemplate) {
      requests.add(request);
      responseObserver.onNext((TagTemplate) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteTagTemplate(
      DeleteTagTemplateRequest request, StreamObserver<Empty> responseObserver) {
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
  public void createTagTemplateField(
      CreateTagTemplateFieldRequest request, StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext((TagTemplateField) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateTagTemplateField(
      UpdateTagTemplateFieldRequest request, StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext((TagTemplateField) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void renameTagTemplateField(
      RenameTagTemplateFieldRequest request, StreamObserver<TagTemplateField> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TagTemplateField) {
      requests.add(request);
      responseObserver.onNext((TagTemplateField) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteTagTemplateField(
      DeleteTagTemplateFieldRequest request, StreamObserver<Empty> responseObserver) {
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
  public void createTag(CreateTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext((Tag) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateTag(UpdateTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext((Tag) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteTag(DeleteTagRequest request, StreamObserver<Empty> responseObserver) {
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
  public void listTags(ListTagsRequest request, StreamObserver<ListTagsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListTagsResponse) {
      requests.add(request);
      responseObserver.onNext((ListTagsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext((Policy) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext((Policy) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext((TestIamPermissionsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
