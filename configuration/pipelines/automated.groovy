CREDENTIALS_ID = 'github'
powershell = 'C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe'

try {

    node( 'master' ) {

        powershell 'Write-Output "Hello World!"'
        
        stage( 'Initialise' ) {
            git url: 'https://github.com/hmniw/rbp-postman-tests.git', branch: 'master', credentialsId: CREDENTIALS_ID
        }

        stage( 'Install Dependencies' ) {
            powershell 'npm install -g newman'
            powershell 'npm install'
        }

        stage( 'Run Tests' ) {
            powershell '../../run-tests.ps1'
        }

    }
} catch (exception) {
    currentBuild.result = 'FAILURE'
    throw exception
}