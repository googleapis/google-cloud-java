output "project_id" {
  value = google_project.project.project_id
}

output "service_account_id" {
  value = google_service_account.service_account.id
}

output "service_account_email" {
  value = google_service_account.service_account.email
}
