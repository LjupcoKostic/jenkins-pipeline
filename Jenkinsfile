pipeline {
   agent any
   
   environment {
       OWNER='Kostic'
   }

   stages {
      stage('stage-1') {
         steps {
            echo "This is build number $BUILD_NUMBER of Owner $OWNER"
            sh '''
               echo "Using a multi-line shell step"
               chmod +x test.sh
               ./test.sh
            '''
         }
      }
   }
}
