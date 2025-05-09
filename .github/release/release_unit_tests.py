from click.testing import CliRunner
import contextlib
import os
import shutil
import tempfile
import unittest
from partial_release import bump_released_version

SCRIPT_DIR = os.path.dirname(os.path.realpath(__file__))
GOLDEN = os.path.join(SCRIPT_DIR, "testdata")
FIXTURES = os.path.join(SCRIPT_DIR, "fixture")
runner = CliRunner()


class TestCase(unittest.TestCase):
    def test_bump_single_version_success(self):
        golden = f"{GOLDEN}/asset/versions-asset-golden.txt"
        with copied_fixtures_dir(f"{FIXTURES}/asset"):
            runner.invoke(
                bump_released_version,
                [
                    "--artifact-ids=google-cloud-asset",
                    "--versions=versions-asset.txt",
                ],
            )
            with open(golden) as g:
                expected = g.read()
            with open("./versions-asset.txt") as f:
                actual = f.read()
            self.assertEqual(expected, actual)

    def test_bump_multiple_versions_success(self):
        golden = f"{GOLDEN}/multiple_modules/versions-multiple-golden.txt"
        with copied_fixtures_dir(f"{FIXTURES}/multiple_modules"):
            runner.invoke(
                bump_released_version,
                [
                    "--artifact-ids=google-cloud-bigqueryconnection,google-cloud-java",
                    "--versions=versions-multiple.txt",
                ],
            )
            with open(golden) as g:
                expected = g.read()
            with open("./versions-multiple.txt") as f:
                actual = f.read()
            self.assertEqual(expected, actual)


@contextlib.contextmanager
def change_dir_to(path: str) -> str:
    """
    Context Manager to change the current working directory and restore the
    previous working directory after completing the context.

    """
    old_cwd = os.getcwd()
    os.chdir(path)
    try:
        yield path
    finally:
        os.chdir(old_cwd)


@contextlib.contextmanager
def copied_fixtures_dir(source: str) -> str:
    """
    Context Manager to copy from a fixtures directory into a new temporary
    directory and change the current working directory to that copy.
    Restores the original current working directory after completing the
    context.

    """
    with tempfile.TemporaryDirectory() as tempdir:
        workdir = shutil.copytree(source, f"{tempdir}/workspace")
        with change_dir_to(workdir):
            yield workdir
