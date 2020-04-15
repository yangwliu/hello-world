pipeline {
    agent any
    stages {
        stage('clone') {
            steps {
                echo 'clone'
            }
        }

        stage('Unit test') {
            steps {
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
                echo 'unit test'
            }
            input {
                message 'trigger next pipeline'
                parameters {
                    string(name: 'trigger', defaultValue: 'No', description: 'trigger or not?')
                }
            }
        }
    }
    post {
            always {
                echo 'I will always say Hello again!'
            }
            success {
                echo 'this is success'
                echo 'deploye ${trigger}'
//                 input message: 'trigger next pipeline' parameters: {string(name: 'trigger', defaultValue: 'No', description: 'trigger or not?')}
                build job: 'triggerd', parameters: [string(name: 'trigger', value: 'Yes')]
            }
        }
}
