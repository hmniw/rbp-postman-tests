CREDENTIALS_ID = 'github'
powershell = "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe"

try {

    node( 'master' ) {

        stage( 'Initialise' ) {
            git url: 'https://github.com/hmniw/rbp-postman-tests.git', branch: 'master', credentialsId: CREDENTIALS_ID
        }

        stage( 'Install Dependencies' ) {
            powershell 'npm install -g newman'
        }

        stage( 'Run Tests' ) {
            powershell './run-tests.ps1'
            publishHTML
        }

    }
} catch (exception) {
    currentBuild.result = 'FAILURE'
    throw exception
}