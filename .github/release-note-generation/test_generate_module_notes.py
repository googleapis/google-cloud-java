import subprocess
import unittest
from pathlib import Path


class TestGenerateModuleNotes(unittest.TestCase):

    def setUp(self):
        self.script_path = Path(
            ".github/release-note-generation/generate_module_notes.py"
        )
        self.testdata_dir = Path(".github/release-note-generation/testdata")

    def test_java_run_generation(self):
        golden_file = self.testdata_dir / "golden_java-run_0.71.0.txt"
        with open(golden_file, "r") as f:
            expected_output = f.read()

        cmd = [
            "python3",
            str(self.script_path),
            "--module",
            "google-cloud-run",
            "--directory",
            "java-run",
            "--version",
            "0.71.0",
            "--short-name",
            "run",
        ]
        result = subprocess.run(
            cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True
        )

        self.assertEqual(result.returncode, 0)
        self.assertEqual(result.stdout, expected_output)

    def test_root_generation(self):
        golden_file = self.testdata_dir / "golden_root_1.85.0.txt"
        with open(golden_file, "r") as f:
            expected_output = f.read()

        cmd = [
            "python3",
            str(self.script_path),
            "--module",
            "google-cloud-java",
            "--directory",
            ".",
            "--version",
            "1.85.0",
        ]
        result = subprocess.run(
            cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True
        )

        self.assertEqual(result.returncode, 0)
        self.assertEqual(result.stdout, expected_output)


if __name__ == "__main__":
    unittest.main()
