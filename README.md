# Faire Weather
Faire Weather is my app submission for the Faire take home test for the Senior Android Engineer role. I have decided to use Jetpack Compose for UI as I have been using it lately for some personal projects and really really enjoy it!

For this project, I wanted to structure it like I would structure a real world project.  Because of this, I have implemented a full MVVM architechture with data, domain, and ui layers. These layers contain:
- Data: This layer contains dto (data transfer object) models, apis and repositories.  This layer is responsible for fetching data from the network.  Later, we could use this layer to also get and store data locally.
- Domain: This layer contains things like domain models, mappers and use cases.  This layer is responsible for housing the business logic that is required to manipulate data that is fetched from the data layer before it gets passed down to the ui layer.
- UI: This layer contains all of our ui code.

I noticed that the data returns a list of Consolidated Weather.  I decided to randomize these and show them in the ui.  That way, I was able to add a refresh mechanism to the app.  When you tap on the screen, it will call the api again and reload the data.  The ui will then show a random weather entry from the Consolidated Weather list.

I would have like to implement a pager into this app so that you could swipe through all of the different Consolidated Weather items however I just did not have time.  I did, however, add in the ability to add new screens very easily so in the future, I could easily add a details screen to show more detail or a search screen to search for different locations.

I have implemented a coupld of simple unit tests for now with the posibility of adding more in the future.  I just did not have time to add any more.

This project uses some external libraries which are:
- Coil for image loading
- Okhttp and Retrofit for networking
- Moshi for json deserialization
- Dagger Hilt for dependency injection
- A couple of accompanist libraries for some compose functionality like navigation

I hope you enjoy this project.  I really like working with Compose, it is a super cool technology and makes writing Android UI fun again! I would love to hear any feedback you may have about this app. Thank you!