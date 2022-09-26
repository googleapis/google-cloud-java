terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "tasks_api" {
  service            = "cloudtasks.googleapis.com"
  disable_on_destroy = false
}

resource "time_sleep" "wait_90_seconds" {
  depends_on      = [google_project_service.tasks_api]
  create_duration = "90s"
}