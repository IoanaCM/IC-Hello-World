warning: LF will be replaced by CRLF in .idea/shelf/Uncommitted_changes_before_Update_at_27_03_2021_14_50__Default_Changelist_.xml.
The file will have its original line endings in your working directory
warning: LF will be replaced by CRLF in .idea/shelf/Uncommitted_changes_before_Update_at_27_03_2021_16_56__Default_Changelist_.xml.
The file will have its original line endings in your working directory
[1mdiff --git a/.idea/gradle.xml b/.idea/gradle.xml[m
[1mindex ac6b0ae..23a89bb 100644[m
[1m--- a/.idea/gradle.xml[m
[1m+++ b/.idea/gradle.xml[m
[36m@@ -15,6 +15,7 @@[m
           </set>[m
         </option>[m
         <option name="resolveModulePerSourceSet" value="false" />[m
[32m+[m[32m        <option name="useQualifiedModuleNames" value="true" />[m
       </GradleProjectSettings>[m
     </option>[m
   </component>[m
[1mdiff --git a/app/src/main/java/com/example/ic_hello_world/NewFoodItem.java b/app/src/main/java/com/example/ic_hello_world/NewFoodItem.java[m
[1mindex 75809a2..63cd821 100644[m
[1m--- a/app/src/main/java/com/example/ic_hello_world/NewFoodItem.java[m
[1m+++ b/app/src/main/java/com/example/ic_hello_world/NewFoodItem.java[m
[36m@@ -1,14 +1,42 @@[m
 package com.example.ic_hello_world;[m
 [m
[32m+[m[32mimport android.content.Intent;[m
 import android.os.Bundle;[m
[32m+[m[32mimport android.view.View;[m
[32m+[m[32mimport android.widget.Button;[m
 [m
 import androidx.appcompat.app.AppCompatActivity;[m
 [m
[32m+[m[32mimport com.google.firebase.auth.FirebaseAuth;[m
[32m+[m
 public class NewFoodItem  extends AppCompatActivity {[m
 [m
[32m+[m[32m    private Button mPost;[m
[32m+[m
[32m+[m[32m    private FirebaseAuth mAuth;[m
[32m+[m[32m    private FirebaseAuth.AuthStateListener firebaseAuthListener;[m
[32m+[m
[32m+[m
     @Override[m
     protected void onCreate(Bundle savedInstanceState) {[m
         super.onCreate(savedInstanceState);[m
         setContentView(R.layout.new_food_item);[m
[32m+[m
[32m+[m[32m        mAuth = FirebaseAuth.getInstance();[m
[32m+[m
[32m+[m[32m        System.out.println(mAuth);[m
[32m+[m
[32m+[m[32m        mPost = (Button) findViewById(R.id.submitFood);[m
[32m+[m
[32m+[m[32m        mPost.setOnClickListener(new View.OnClickListener() {[m
[32m+[m[32m            @Override[m
[32m+[m[32m            public void onClick(View v) {[m
[32m+[m[32m                testAddItem addItem = new testAddItem(mAuth);[m
[32m+[m[32m                addItem.writeNewItem("fromHere",2,"date");[m
[32m+[m[32m                return;[m
[32m+[m[32m            }});[m
[32m+[m
     }[m
[32m+[m
[32m+[m
 }[m
