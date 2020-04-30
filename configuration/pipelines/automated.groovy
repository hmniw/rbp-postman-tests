CREDENTIALS_ID = 'github'
powershell = "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe"

try {

    node( 'master' ) {

        %SystemRoot%\system32\WindowsPowerShell\v1.0\powershell.exe 'Write-Output "Hello World!"'

        stage( 'Initialise' ) {
            git url: 'https://github.com/hmniw/rbp-postman-tests.git', branch: 'master', credentialsId: CREDENTIALS_ID
        }

        stage( 'Install Dependencies' ) {
            %SystemRoot%\system32\WindowsPowerShell\v1.0\powershell.exe 'npm install -g newman'
            %SystemRoot%\system32\WindowsPowerShell\v1.0\powershell.exe 'npm install'
        }

        stage( 'Run Tests' ) {
            %SystemRoot%\system32\WindowsPowerShell\v1.0\powershell.exe '../../run-tests.ps1'
        }

    }
} catch (exception) {
    currentBuild.result = 'FAILURE'
    throw exception
}