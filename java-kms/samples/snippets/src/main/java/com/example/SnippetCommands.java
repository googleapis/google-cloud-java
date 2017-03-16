/*
 * Copyright (c) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import java.io.IOException;

/**
 * Defines the different sub-commands and their parameters, for command-line invocation.
 */
class SnippetCommands {
  /**
   * An interface for a command-line sub-command.
   */
  interface Command {
    public void run() throws IOException;
  }

  // Most of the commands take some subset of the same arguments, so specify groups of arguments
  // as classes for greater code reuse.
  static class ProjectIdArgs {
    @Option(name = "--project-id", aliases = "-p", required = true, usage = "Your GCP project ID")
    String projectId;
  }

  static class KeyRingArgs extends ProjectIdArgs {
    @Argument(metaVar = "ringId", required = true, index = 0, usage = "The ring id")
    String ringId;
  }

  static class KeyArgs extends KeyRingArgs {
    @Argument(metaVar = "keyId", required = true, index = 1, usage = "The key id")
    String keyId;
  }

  static class KeyVersionArgs extends KeyArgs {
    @Argument(metaVar = "version", required = true, index = 2, usage = "The key version")
    String version;
  }


  public static class CreateKeyRingCommand extends KeyRingArgs implements Command {
    public void run() throws IOException {
      Snippets.createKeyRing(projectId, ringId);
    }
  }

  public static class CreateCryptoKeyCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.createCryptoKey(projectId, ringId, keyId);
    }
  }

  public static class CreateCryptoKeyVersionCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.createCryptoKeyVersion(projectId, ringId, keyId);
    }
  }

  public static class ListKeyRingsCommand extends ProjectIdArgs implements Command {
    public void run() throws IOException {
      Snippets.listKeyRings(projectId);
    }
  }

  public static class ListCryptoKeysCommand extends KeyRingArgs implements Command {
    public void run() throws IOException {
      Snippets.listCryptoKeys(projectId, ringId);
    }
  }

  public static class ListCryptoKeyVersionsCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.listCryptoKeyVersions(projectId, ringId, keyId);
    }
  }

  public static class DisableCryptoKeyVersionCommand extends KeyVersionArgs implements Command {
    public void run() throws IOException {
      Snippets.disableCryptoKeyVersion(projectId, ringId, keyId, version);
    }
  }

  public static class DestroyCryptoKeyVersionCommand extends KeyVersionArgs implements Command {
    public void run() throws IOException {
      Snippets.destroyCryptoKeyVersion(projectId, ringId, keyId, version);
    }
  }

  public static class GetKeyRingPolicyCommand extends KeyRingArgs implements Command {
    public void run() throws IOException {
      Snippets.getKeyRingPolicy(projectId, ringId);
    }
  }

  public static class GetCryptoKeyPolicyCommand extends KeyArgs implements Command {
    public void run() throws IOException {
      Snippets.getCryptoKeyPolicy(projectId, ringId, keyId);
    }
  }

  public static class AddMemberToKeyRingPolicyCommand extends KeyRingArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 1,
        usage = "The member to add.\n"
        + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
        + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 2,
        usage = "The role for the member.\n"
        + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets.addMemberToKeyRingPolicy(projectId, ringId, member, role);
    }
  }

  public static class AddMemberToCryptoKeyPolicyCommand extends KeyArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 2,
        usage = "The member to add.\n"
        + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
        + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 3,
        usage = "The role for the member.\n"
        + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets.addMemberToCryptoKeyPolicy(projectId, ringId, keyId, member, role);
    }
  }

  public static class RemoveMemberFromKeyRingPolicyCommand extends KeyRingArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 1,
        usage = "The member to add.\n"
        + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
        + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 2,
        usage = "The role for the member.\n"
        + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets.removeMemberFromKeyRingPolicy(projectId, ringId, member, role);
    }
  }

  public static class RemoveMemberFromCryptoKeyPolicyCommand extends KeyArgs implements Command {
    @Argument(metaVar = "member", required = true, index = 2,
        usage = "The member to add.\n"
        + "See https://g.co/cloud/kms/docs/reference/rest/v1/Policy#binding "
        + "for valid values.")
    String member;
    @Argument(metaVar = "role", required = true, index = 3,
        usage = "The role for the member.\n"
        + "See https://g.co/cloud/iam/docs/understanding-roles for valid values.")
    String role;

    public void run() throws IOException {
      Snippets.removeMemberFromCryptoKeyPolicy(projectId, ringId, keyId, member, role);
    }
  }

  @Argument(metaVar = "command", required = true, handler = SubCommandHandler.class,
      usage = "The subcommand to run")
  @SubCommands({
      @SubCommand(name = "createKeyRing", impl = CreateKeyRingCommand.class),
      @SubCommand(name = "createCryptoKey", impl = CreateCryptoKeyCommand.class),
      @SubCommand(name = "createCryptoKeyVersion", impl = CreateCryptoKeyVersionCommand.class),
      @SubCommand(name = "listKeyRings", impl = ListKeyRingsCommand.class),
      @SubCommand(name = "listCryptoKeys", impl = ListCryptoKeysCommand.class),
      @SubCommand(name = "listCryptoKeyVersions", impl = ListCryptoKeyVersionsCommand.class),
      @SubCommand(name = "disableCryptoKeyVersion", impl = DisableCryptoKeyVersionCommand.class),
      @SubCommand(name = "destroyCryptoKeyVersion", impl = DestroyCryptoKeyVersionCommand.class),
      @SubCommand(name = "getKeyRingPolicy", impl = GetKeyRingPolicyCommand.class),
      @SubCommand(name = "getCryptoKeyPolicy", impl = GetCryptoKeyPolicyCommand.class),
      @SubCommand(name = "addMemberToKeyRingPolicy", impl = AddMemberToKeyRingPolicyCommand.class),
      @SubCommand(name = "addMemberToCryptoKeyPolicy",
          impl = AddMemberToCryptoKeyPolicyCommand.class),
      @SubCommand(name = "removeMemberFromKeyRingPolicy",
          impl = RemoveMemberFromKeyRingPolicyCommand.class),
      @SubCommand(name = "removeMemberFromCryptoKeyPolicy",
          impl = RemoveMemberFromCryptoKeyPolicyCommand.class)
      })
  Command command;
}
