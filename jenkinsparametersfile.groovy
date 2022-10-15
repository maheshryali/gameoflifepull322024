pipeline {
    agent { label 'GAMEOFLIFE' }
    parameters {
        choice(name:'Java_version', choices: ['8', '11'], description: 'forbranchselection')
        choice(name:'branchname', choices: ['master', 'branch1'], description: 'forbranchselection')
        choice(name:'MAVEN', choices: ['clean', 'package','clean install','clean package','test'], description: 'forbranchselection')
        //string(name: 'MAVEN1', defaultValue: 'package', description: 'forselectingmaven')
    }
    triggers {
        cron('43 10 * * *')
    }
    stages {
        stage('vcs') {
            steps {
            git branch: "${params.branchname}",
                   url: 'https://github.com/maheshryali/game-of-life.git'
                   }
        }
        stage('mavenbuild') {
            steps {
                sh """
                export JAVA_HOME='/usr/lib/jvm/java-8-openjdk-amd64'
                mvn ${params.MAVEN}
                """
                /*
                script{
                    if (${params.Java_version} == '8'){
                        export JAVA_HOME=""
                        sh " mvn ${params.MAVEN}"
                    }
                    elseif (${params.Java_version} == '11'){
                        export JAVA_HOME=""
                        sh " mvn ${params.MAVEN}"
                    }
                    else {
                        sh " mvn ${params.MAVEN}"
                    }
                }
                */
            }
        }
    }
}