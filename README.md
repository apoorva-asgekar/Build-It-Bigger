This project has the following modules in the app:
1) A java library which supplies jokes.
2) An android library with an activity to display these jokes received as an intent.
3) A Google Cloud Endpoints module which retrieves the jokes from the java library and then supply them to the app.
4) The mobile app which ties all of these elements together by fetching the jokes from the GCE module and using the android library to display them.
