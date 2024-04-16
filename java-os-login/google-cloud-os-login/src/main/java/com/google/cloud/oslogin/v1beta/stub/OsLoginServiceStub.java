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

package com.google.cloud.oslogin.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.oslogin.common.OsLoginProto;
import com.google.cloud.oslogin.v1beta.CreateSshPublicKeyRequest;
import com.google.cloud.oslogin.v1beta.DeletePosixAccountRequest;
import com.google.cloud.oslogin.v1beta.DeleteSshPublicKeyRequest;
import com.google.cloud.oslogin.v1beta.GetLoginProfileRequest;
import com.google.cloud.oslogin.v1beta.GetSshPublicKeyRequest;
import com.google.cloud.oslogin.v1beta.ImportSshPublicKeyRequest;
import com.google.cloud.oslogin.v1beta.ImportSshPublicKeyResponse;
import com.google.cloud.oslogin.v1beta.LoginProfile;
import com.google.cloud.oslogin.v1beta.SignSshPublicKeyRequest;
import com.google.cloud.oslogin.v1beta.SignSshPublicKeyResponse;
import com.google.cloud.oslogin.v1beta.UpdateSshPublicKeyRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OsLoginService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class OsLoginServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      createSshPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createSshPublicKeyCallable()");
  }

  public UnaryCallable<DeletePosixAccountRequest, Empty> deletePosixAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePosixAccountCallable()");
  }

  public UnaryCallable<DeleteSshPublicKeyRequest, Empty> deleteSshPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSshPublicKeyCallable()");
  }

  public UnaryCallable<GetLoginProfileRequest, LoginProfile> getLoginProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getLoginProfileCallable()");
  }

  public UnaryCallable<GetSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      getSshPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getSshPublicKeyCallable()");
  }

  public UnaryCallable<ImportSshPublicKeyRequest, ImportSshPublicKeyResponse>
      importSshPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: importSshPublicKeyCallable()");
  }

  public UnaryCallable<UpdateSshPublicKeyRequest, OsLoginProto.SshPublicKey>
      updateSshPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSshPublicKeyCallable()");
  }

  public UnaryCallable<SignSshPublicKeyRequest, SignSshPublicKeyResponse>
      signSshPublicKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: signSshPublicKeyCallable()");
  }

  @Override
  public abstract void close();
}
