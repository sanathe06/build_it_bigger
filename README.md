# [Build It Bigger](https://classroom.udacity.com/nanodegrees/nd801/parts/8011345408/modules/429520885375461/lessons/4295208853239847/concepts/42732622150923)


## Steps
* Step 1: Create a Java library - *done*

* Step 2: Create an Android Library - *done*

* Step 3: Create GCE Module - *done*

* Step 4: Add Functional Tests - *done*

* Step 5: Add a Paid Flavor - *done*

* Optional Tasks
For extra practice to make your project stand out, complete the following tasks.

	* Add Interstitial Ad - *done*

	* Add Loading Indicator - *done*

	* Configure Test Task - *done*

		* Launches the GCE local development server
		* Runs all tests
		* Shuts the server down again

## Note
* I have used sample ad unit ids for testing purposes. If somw one need real ads please replace those with your ad unit ids in free flavor string resources file.

	```
	<string name="banner_ad_unit_id">ca-app-pub-3940256099942544/6300978111</string>
	<string name="interstitial_ad_unit_id">ca-app-pub-3940256099942544/1033173712</string>
	```

* To test configured test task please run following command in terminal 

 	```
	./gradlew appTest
	```

