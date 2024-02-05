pipeline {
    agent any
// test
    stages {
        stage('Build') {
            steps {
                sh "pwd"
                sh "ls"
                sh "chmod +x -R ${env.WORKSPACE}"
                echo 'Starting Selenium script'
                sh './testscript.sh'
                sh './run.sh'
                echo 'Finished Selenium script'
            }
        }
    }
}