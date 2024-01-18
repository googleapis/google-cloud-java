# CHANGELOG.md Generation Script

The script `split_release_note.py` splits the main changelog prepared by
Release Please into the CHANGELOG.md files in the modules of google-cloud-java
repository.

## Trigger

GitHub Actions' pull request triggers the script upon Release Please pull
requests and adds an　additional commit CHANGELOG.md within the same pull
requests. The `.github/workflows/changelog_generation.yaml` defines the
workflow.

## Test

The `.github/workflows/changelog_generation_test.yaml` defines pull request
check when we modify the generation logic with unit tests and golden test.

### Unit Test

Unit tests for the functions in the Python script is in `unit_test.py`.
You can run it as below:

```
~/google-cloud-java $ python3 .github/release-note-generation/unit_test.py
...
OK
```

### Golden Test

The golden test serves as a integration test.
You can run it as below:

```
~/google-cloud-java $ sh .github/release-note-generation/golden_test.sh
...
Golden test passed
```
