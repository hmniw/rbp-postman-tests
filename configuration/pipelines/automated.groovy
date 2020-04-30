CREDENTIALS_ID = 'github'
powershell = env.powershell

try {

    node( 'master' ) {

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