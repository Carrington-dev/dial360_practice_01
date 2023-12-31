# Dial360 Practice 01

## Items Added

Practiced Country Picker and PinView for OTP
Hope to add more items in the future like

- API
	- Json
	- Generate a json text from objects
	- __using gson library from google__
- Integrate with API
- Android
- Style my UI/UX
- Aim to understand Network protocols
- Database like Sqlite
- Make a book from given sqlite files e.g hymm book or Bible

## How to Implement OTP View in Android?


Step 3: Navigate to the Gradle Scripts > build.gradle(Module:app) and add the below dependency in the dependencies section.  

```
implementation("io.github.chaosleung:pinview:1.4.4")

```


Step 4: Navigate to the __app > res > layout > activity_main.xml__ and add the below code to that file
```xml

<?xml version="1.0" encoding="utf-8"?> 
<androidx.constraintlayout.widget.ConstraintLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	tools:context=".MainActivity"
	android:layout_marginTop="30dp"
	android:layout_marginLeft="30dp"
	android:layout_marginRight="30dp"> 

	<TextView
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="OTPView "
		android:textSize="30sp"
		android:textStyle="bold"
		app:layout_constraintTop_toTopOf="parent"
		app:layout_constraintRight_toRightOf="parent"
		app:layout_constraintLeft_toLeftOf="parent"/> 

	<com.chaos.view.PinView
		android:id="@+id/pinview"
		app:itemCount="6"
		app:itemWidth="50dp"
		app:itemHeight="50dp"
		android:gravity="center"
		android:layout_marginTop="60dp"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:itemBackground="@color/white"
		android:layout_gravity="center"
		android:inputType="number"
		android:cursorVisible="true"
		app:hideLineWhenFilled="false"
		app:itemRadius="10dp"
		style="@style/PinWidget.PinView"
		app:layout_constraintRight_toRightOf="parent"
		app:layout_constraintLeft_toLeftOf="parent"
		app:layout_constraintTop_toTopOf="parent"
		></com.chaos.view.PinView> 
	
	<Button
		android:id="@+id/show_otp"
		android:layout_width="140dp"
		android:layout_height="60dp"
		android:text="Show OTP"
		app:layout_constraintTop_toBottomOf="@+id/pinview"
		app:layout_constraintLeft_toLeftOf="parent"
		app:layout_constraintRight_toRightOf="parent"
		android:layout_marginTop="20dp"
		></Button> 

</androidx.constraintlayout.widget.ConstraintLayout>

```

Activity.java
```java
package com.example.otp; 

import androidx.appcompat.app.AppCompatActivity; 

import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.Toast; 

import com.chaos.view.PinView; 

public class MainActivity extends AppCompatActivity { 

	PinView pinView; 
	Button button; 

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 

		// hookers (binding view) 
		pinView=findViewById(R.id.pinview); 

		button=findViewById(R.id.show_otp); 

		// setting onClickListener on Button 
		button.setOnClickListener(new View.OnClickListener() { 
			@Override
			public void onClick(View view) { 

				// getting the PinView data 
				String otp=pinView.getText().toString(); 

				// Toast to show the OTP Data 
				Toast.makeText(MainActivity.this, otp, Toast.LENGTH_SHORT).show(); 

			} 
		}); 
	} 
}

```