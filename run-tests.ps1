$collection='room_controller_tests.postman_collection.json'
$environment='environment_variables.postman_environment.json'
$output=$(newman run $collection -e $environment -r htmlextra --reporter-htmlextra-export newman/report.html --reporter-htmlextra-title "RBP Room Controller Tests")

Write-Host $output