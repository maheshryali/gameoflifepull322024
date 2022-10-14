pipeline{
    agent {'GAMEOFLIFE'}
    parameters {
        choice(name: 'branch_1', choices: ['master', 'branch1'], description: 'this isfor barnchselection')
        string(name: 'MAVEN', defaultValue: 'mvn package', description: 'this is for maven build')
    }
    stages{
        stage('vcs'){
            git branch : "${params.branch_1},
                   url : 'https://github.com/maheshryali/game-of-life.git' 
        }
        stage('mavenbuild'){
            sh "${params.MAVEN}"
        }
        stage('archiveartifactory'){
            sh ('gameoflife-web/target/*.war)
        }
        stage('testreportxmls'){
            sh ('**/surefire-reports/*.xml)
        }
    }
}