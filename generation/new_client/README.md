# New Google Client Library Generation

The script allows you to create a new client library module in the
google-cloud-java monorepo.

**This tool is for repository maintainers only. Not for library users.**

## Prerequisites

This section is only needed for the first run of this script. If it's already
done, go to "Run client generation script" section.


### Environment

Use Linux environment.

Install Docker.

### Checkout google-cloud-java repository

```
$ git clone https://github.com/googleapis/google-cloud-java
$ git checkout main
$ git pull
```

### Install pyenv

Install pyenv

```
curl -L https://github.com/pyenv/pyenv-installer/raw/master/bin/pyenv-installer \
| bash
```

Append the following lines to `$HOME/.bashrc`.

```
export PYENV_ROOT="$HOME/.pyenv"
command -v pyenv >/dev/null || export PATH="$PYENV_ROOT/bin:$PATH"
eval "$(pyenv init -)"
eval "$(pyenv virtualenv-init -)"
```

Logout the shell and login again.

Confirm pyenv installation succeeded:

```
suztomo@suztomo:~$ pyenv
pyenv 2.3.4
Usage: pyenv <command> [<args>]

Some useful pyenv commands are:
   activate    Activate virtual environment
   commands    List all available pyenv commands
   deactivate   Deactivate virtual environment
...
```

### Install Python 3.9 via pyenv

```
suztomo@suztomo:~$ pyenv install 3.9.13
Downloading Python-3.9.13.tar.xz...
-> https://www.python.org/ftp/python/3.9.13/Python-3.9.13.tar.xz
Installing Python-3.9.13...
WARNING: The Python sqlite3 extension was not compiled. Missing the SQLite3 lib?
Installed Python-3.9.13 to /usr/local/google/home/suztomo/.pyenv/versions/3.9.13
```

Conform `python3.9` command is available:

```
$ pyenv local 3.9.13
$ which python3.9
/usr/local/google/home/suztomo/.pyenv/shims/python3.9
```

### Install Python packages

At the root of google-cloud-java repository clone, run:

```
$ python3.9 -m pip install -r generation/new_client/requirements.txt
```

### Install GitHub CLI (Optional)

Install the GitHub CLI and login, if needed:

```
$ sudo apt-get install gh
$ gh auth login
```

## Run client generation script

You will run new-client.py script with the following parameters.
Collect them from the ticket before running the command.

### API short name

For convenience of the subsequent commands, define a variable for API short name.
Get the value from the DevRel Services page (Example: `apikeys`):

### proto path

The script takes "proto path" parameter. This is path from google3's root to the
directory that contains versions (e.g., "v1" or "v2"). For example, if we
have 

> Link to protos: http://google3/google/api/apikeys/v2/apikeys.proto

then the "proto path" value we supply to the command is "google/api/apikeys".

### Name pretty

Pick name from the display name in the DevRel Services site.
For example, "API Keys API" in
https://devrel.corp.google.com/admin/products/479.

### Product Docs

Find product document URL in the DevRel Services site.
For example, "https://cloud.google.com/api-keys/" in
https://devrel.corp.google.com/admin/products/479.
The value must starts with "https://".

### API description

Find the short description of the API. Usually the first sentence in the product
document above.

### Example arguments

Run `new-client.py` with the arguments above:

```
$ python3.9 generation/new_client/new-client.py generate \
  --api_shortname=apikeys \
  --proto-path=google/api/apikeys \
  --name-pretty="API Keys API" \
  --product-docs="https://cloud.google.com/api-keys/" \
  --api-description="API Keys lets you create and manage your API keys for your projects."
```

The command creates changes for
the new module in the monorepo. At the end (~ 10 minutes), it tells you to
create a pull request in the monorepo:

```
...
Please create a pull request:
  $ git checkout -b new_module_java-discoveryengine
  $ git add .
  $ git commit -m 'feat: [apikeys] new module for apikeys'
  $ gh pr create --title 'feat: [apikeys] new module for apikeys'
```

Create a pull request from the change.

# Principles

The script should finish creating a pull request even when the newly created
module fails to compile. This gives the user flexibility to fix things in the
created pull request.




